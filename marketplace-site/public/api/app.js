const accountStatus = document.querySelector("#api-account-status");
const search = document.querySelector("#api-search");
const sectionFilter = document.querySelector("#api-section-filter");
const kindFilter = document.querySelector("#api-kind-filter");
const methodsOnly = document.querySelector("#api-methods-only");
const summary = document.querySelector("#api-summary");
const content = document.querySelector("#api-content");
const logout = document.querySelector("#api-logout");
let reference = null;

const SECTION_GUIDES = {
  "Client API": {
    description: "Read current client state and request controlled client interactions. Start here for inventory, NPCs, players, widgets, combat, banking, camera, settings, and definitions.",
    useWhen: "Use this area whenever the plugin needs to observe the game or perform one focused client action."
  },
  "Automation runtime": {
    description: "Run multi-step work with an explicit lifecycle. These types help automation start, stop, wait, report status, and avoid mixing long-running logic into plugin UI code.",
    useWhen: "Use this area when work continues across multiple ticks, screens, destinations, or recovery states."
  },
  "Web walker": {
    description: "Plan and execute travel toward world destinations while tracking route and movement progress.",
    useWhen: "Use this area when the player must travel beyond a nearby direct interaction or minimap click."
  }
};

const TYPE_DESCRIPTIONS = {
  DefaultKLiteClientApi: "The built-in implementation of KLiteClientApi. Plugin code should normally depend on the KLiteClientApi interface rather than constructing this implementation directly.",
  KLiteClientApi: "The primary public entry point for reading client state and requesting controlled interactions. Calls complete asynchronously so work can be coordinated safely with the client.",
  KLiteInteractionResult: "Describes the outcome of a requested client interaction. Check this value before assuming that a click, selection, withdrawal, or other action succeeded.",
  KLiteBankQuantity: "Selects how many items a bank withdrawal or deposit operation should move.",
  KLiteMenuActionRequest: "Carries the parameters required to submit a low-level menu action. Prefer a specific high-level interaction method when one is available.",
  KLiteClientSnapshot: "A broad point-in-time view of important client state. Use narrower snapshots when only one subsystem is needed.",
  KLiteItemStack: "Represents an item entry and its quantity in an inventory-style container.",
  KLiteAutomationStatus: "Reports the current lifecycle or execution state of an automation task.",
  KLiteWalkerStatus: "Reports the current state of a web-walker request, such as planning, travelling, completed, stopped, or failed."
};

const ACTION_PREFIXES = [
  "accept", "add", "choose", "clear", "close", "collect", "continue", "decline",
  "deposit", "hop", "interact", "invalidate", "open", "play", "queue", "refresh",
  "run", "select", "set", "use", "withdraw", "walk", "start", "stop", "cancel", "pause", "resume"
];

async function request(path, options = {}) {
  const response = await fetch(path, {
    ...options,
    headers: {
      "content-type": "application/json",
      ...(options.headers || {})
    }
  });
  const payload = await response.json().catch(() => ({}));
  if (!response.ok) {
    const error = new Error(payload.error?.message || `Request failed (${response.status})`);
    error.status = response.status;
    throw error;
  }
  return payload;
}

async function load() {
  try {
    const account = await request("/api/account");
    accountStatus.textContent = `Signed in as ${account.account.username} / ${account.account.email}`;
    logout.hidden = false;
    reference = await request("/api/docs");
    populateFilters();
    render();
  } catch (error) {
    if (error.status === 401) {
      accountStatus.textContent = "Sign in on the marketplace to view the searchable type reference.";
      content.innerHTML = '<div class="api-auth-required"><p>The orientation guide above remains available, but type and method details require a marketplace session.</p><a class="button button-primary" href="/?signin=1">Return to sign in</a></div>';
      search.disabled = true;
      sectionFilter.disabled = true;
      kindFilter.disabled = true;
      methodsOnly.disabled = true;
      return;
    }
    accountStatus.textContent = error.message;
  }
}

function populateFilters() {
  const sections = (reference.sections || []).map((section) => section.name);
  for (const name of sections) {
    const option = document.createElement("option");
    option.value = name;
    option.textContent = name;
    sectionFilter.append(option);
  }

  const kinds = new Set();
  for (const section of reference.sections || []) {
    for (const type of section.types || []) kinds.add(type.kind);
  }
  for (const kind of [...kinds].sort()) {
    const option = document.createElement("option");
    option.value = kind;
    option.textContent = capitalize(kind);
    kindFilter.append(option);
  }
}

function render() {
  if (!reference) return;
  const query = search.value.trim().toLowerCase();
  const selectedSection = sectionFilter.value;
  const selectedKind = kindFilter.value;
  const requireMethods = methodsOnly.checked;
  content.replaceChildren();

  let visibleTypes = 0;
  let visibleMethods = 0;
  let visibleSections = 0;

  for (const section of reference.sections || []) {
    if (selectedSection && section.name !== selectedSection) continue;

    const matching = (section.types || []).filter((type) => {
      if (selectedKind && type.kind !== selectedKind) return false;
      if (requireMethods && !(type.signatures || []).length) return false;
      if (!query) return true;

      const explanationText = (type.signatures || [])
        .map((signature) => `${signature} ${explainSignature(signature)}`)
        .join(" ");
      return [
        type.name,
        type.packageName,
        typeDescription(type),
        typeUsage(type),
        explanationText
      ].join(" ").toLowerCase().includes(query);
    });

    if (!matching.length) continue;
    visibleSections += 1;

    const sectionGuide = SECTION_GUIDES[section.name] || {
      description: "Public KLite types grouped by package and responsibility.",
      useWhen: "Open a type below to inspect its purpose and callable methods."
    };
    const sectionHeading = document.createElement("section");
    sectionHeading.className = "api-reference-section-heading";
    const headingCopy = document.createElement("div");
    const heading = document.createElement("h2");
    heading.textContent = section.name;
    const description = document.createElement("p");
    description.textContent = sectionGuide.description;
    const useWhen = document.createElement("small");
    useWhen.textContent = sectionGuide.useWhen;
    headingCopy.append(heading, description, useWhen);
    const count = document.createElement("span");
    count.className = "api-count-badge";
    count.textContent = `${matching.length} ${matching.length === 1 ? "type" : "types"}`;
    sectionHeading.append(headingCopy, count);
    content.append(sectionHeading);

    for (const type of matching) {
      visibleTypes += 1;
      visibleMethods += (type.signatures || []).length;
      content.append(renderType(type));
    }
  }

  if (!visibleTypes) {
    content.innerHTML = '<div class="api-empty-state"><strong>No API types match the current filters.</strong><p>Try a broader search or clear one of the filters.</p></div>';
  }

  summary.textContent = visibleTypes
    ? `Showing ${visibleTypes} of ${reference.typeCount} public types and ${visibleMethods} callable signatures across ${visibleSections} API ${visibleSections === 1 ? "area" : "areas"}.`
    : `No matches. The complete reference contains ${reference.typeCount} public types and ${reference.methodCount} callable signatures.`;
}

function renderType(type) {
  const details = document.createElement("details");
  details.className = "api-type";

  const title = document.createElement("summary");
  const titleCopy = document.createElement("span");
  titleCopy.className = "api-type-title-copy";
  const name = document.createElement("strong");
  name.textContent = type.name;
  const shortDescription = document.createElement("small");
  shortDescription.textContent = typeDescription(type);
  titleCopy.append(name, shortDescription);

  const badges = document.createElement("span");
  badges.className = "api-type-badges";
  const kind = document.createElement("span");
  kind.className = "api-kind-badge";
  kind.textContent = type.kind;
  const methodCount = document.createElement("span");
  methodCount.className = "api-method-count";
  const signatures = type.signatures || [];
  methodCount.textContent = signatures.length ? `${signatures.length} methods` : "data type";
  badges.append(kind, methodCount);
  title.append(titleCopy, badges);

  const body = document.createElement("div");
  body.className = "api-type-body";

  const packageLabel = document.createElement("div");
  packageLabel.className = "api-package-row";
  const packageTitle = document.createElement("span");
  packageTitle.textContent = "Import";
  const packageName = document.createElement("code");
  packageName.textContent = `${type.packageName}.${type.name}`;
  packageLabel.append(packageTitle, packageName);

  const purpose = document.createElement("div");
  purpose.className = "api-type-explanation";
  purpose.innerHTML = `<strong>What it does</strong><p>${escapeHtml(typeDescription(type))}</p>`;

  const usage = document.createElement("div");
  usage.className = "api-type-explanation";
  usage.innerHTML = `<strong>When to use it</strong><p>${escapeHtml(typeUsage(type))}</p>`;

  body.append(packageLabel, purpose, usage);

  if (signatures.length) {
    const methodsHeading = document.createElement("div");
    methodsHeading.className = "api-methods-heading";
    methodsHeading.innerHTML = `<strong>Callable methods</strong><span>${signatures.length} total</span>`;
    body.append(methodsHeading);

    const groups = groupSignatures(signatures);
    for (const [groupName, groupSignaturesList] of groups) {
      const group = document.createElement("section");
      group.className = "api-method-group";
      const groupTitle = document.createElement("h3");
      groupTitle.textContent = groupName;
      group.append(groupTitle);

      for (const signature of groupSignaturesList) {
        group.append(renderMethod(signature));
      }
      body.append(group);
    }
  } else {
    const noMethods = document.createElement("div");
    noMethods.className = "api-data-type-note";
    noMethods.innerHTML = `<strong>No callable methods are listed for this type.</strong><p>This is usually a snapshot, request object, result object, record, or enum used by another API call. Inspect its fields, accessors, or enum constants in your IDE.</p>`;
    body.append(noMethods);
  }

  details.append(title, body);
  return details;
}

function renderMethod(signature) {
  const parsed = parseSignature(signature);
  const method = document.createElement("article");
  method.className = "api-method";

  const top = document.createElement("div");
  top.className = "api-method-top";
  const code = document.createElement("code");
  code.textContent = signature;
  const copy = document.createElement("button");
  copy.type = "button";
  copy.className = "api-copy-button";
  copy.dataset.signature = signature;
  copy.textContent = "Copy";
  top.append(code, copy);

  const explanation = document.createElement("p");
  explanation.textContent = explainSignature(signature);
  method.append(top, explanation);

  if (parsed.parameters.length) {
    const parameters = document.createElement("div");
    parameters.className = "api-parameter-list";
    for (const parameter of parsed.parameters) {
      const item = document.createElement("span");
      item.innerHTML = `<code>${escapeHtml(parameter.name)}</code><small>${escapeHtml(parameter.type)}</small>`;
      parameters.append(item);
    }
    method.append(parameters);
  }

  const returnNote = returnExplanation(parsed.returnType);
  if (returnNote) {
    const returns = document.createElement("small");
    returns.className = "api-return-note";
    returns.innerHTML = `<strong>Returns:</strong> ${escapeHtml(returnNote)}`;
    method.append(returns);
  }
  return method;
}

function groupSignatures(signatures) {
  const order = ["Read current state", "Find or inspect", "Interactions and actions", "Configuration", "Lifecycle and movement", "Utilities"];
  const groups = new Map(order.map((name) => [name, []]));
  for (const signature of signatures) {
    groups.get(methodCategory(parseSignature(signature).name)).push(signature);
  }
  return [...groups.entries()]
    .map(([name, values]) => [name, values.sort((left, right) => parseSignature(left).name.localeCompare(parseSignature(right).name))])
    .filter(([, values]) => values.length);
}

function methodCategory(name) {
  if (/^(is|has|contains|keyPressed|prayerActive|widgetTargetSelected|worldMapContains)/.test(name)
      || /(Contains|Active|Open|Enabled)$/.test(name)) return "Read current state";
  if (/^(nearest|first|distance|count|find|worldViewAt|itemDefinition|npcDefinition|objectDefinition|questState|widget|inventory|equipment|bank|players|npcs|skills|worlds|snapshot|.*Snapshot)/.test(name)) return "Find or inspect";
  if (/^(set|invalidate|toggle|enable|disable)/.test(name)) return "Configuration";
  if (/^(start|stop|cancel|pause|resume|walk|route|status|tick)/.test(name)) return "Lifecycle and movement";
  if (ACTION_PREFIXES.some((prefix) => name.startsWith(prefix))) return "Interactions and actions";
  return "Utilities";
}

function parseSignature(signature) {
  const normalized = signature.replace(/\s+/g, " ").trim();
  const match = normalized.match(/^(.*?)\s+([A-Za-z_$][\w$]*)\s*\((.*)\)(?:\s+throws\s+.*)?$/);
  if (!match) return { returnType: "", name: normalized, parameters: [] };
  return {
    returnType: match[1].trim(),
    name: match[2],
    parameters: splitParameters(match[3])
  };
}

function splitParameters(raw) {
  if (!raw.trim()) return [];
  const parts = [];
  let current = "";
  let depth = 0;
  for (const character of raw) {
    if (character === "<" || character === "(" || character === "[") depth += 1;
    if (character === ">" || character === ")" || character === "]") depth -= 1;
    if (character === "," && depth === 0) {
      parts.push(current.trim());
      current = "";
    } else {
      current += character;
    }
  }
  if (current.trim()) parts.push(current.trim());
  return parts.map((part, index) => {
    const clean = part.replace(/\s+/g, " ").trim();
    const lastSpace = clean.lastIndexOf(" ");
    return lastSpace > 0
      ? { type: clean.slice(0, lastSpace), name: clean.slice(lastSpace + 1) }
      : { type: clean, name: `argument${index + 1}` };
  });
}

function explainSignature(signature) {
  const parsed = parseSignature(signature);
  const subject = humanize(parsed.name);
  let explanation;

  if (parsed.name.endsWith("Contains")) {
    explanation = `Checks whether the ${lowerFirst(humanize(parsed.name.slice(0, -8)))} contains a matching item or value.`;
  } else if (parsed.name.startsWith("is")) {
    explanation = `Checks whether ${lowerFirst(subject.replace(/^Is /, ""))} is currently true.`;
  } else if (parsed.name.startsWith("has")) {
    explanation = `Checks whether ${lowerFirst(subject.replace(/^Has /, ""))} is currently available.`;
  } else if (parsed.name.endsWith("Active")) {
    explanation = `Checks whether ${lowerFirst(subject.replace(/ Active$/, ""))} is currently active.`;
  } else if (parsed.name.endsWith("Open")) {
    explanation = `Checks whether ${lowerFirst(subject.replace(/ Open$/, ""))} is currently open.`;
  } else if (parsed.name.endsWith("Enabled")) {
    explanation = `Checks whether ${lowerFirst(subject.replace(/ Enabled$/, ""))} is currently enabled.`;
  } else if (parsed.name.startsWith("nearest")) {
    explanation = `Finds the nearest currently available ${lowerFirst(subject.replace(/^Nearest /, ""))} that matches the supplied criteria.`;
  } else if (parsed.name.startsWith("first")) {
    explanation = `Finds the first matching ${lowerFirst(subject.replace(/^First /, ""))}.`;
  } else if (parsed.name.endsWith("Snapshot") || parsed.name === "snapshot") {
    explanation = `Captures a point-in-time view of ${lowerFirst(subject.replace(/ Snapshot$/, ""))}.`;
  } else if (/^(inventory|equipment|bank|players|npcs|skills|worlds|friends|ignores|projectiles|sceneObjects|groundItems|graphicsObjects|dialogOptions|grandExchangeOffers)$/.test(parsed.name)) {
    explanation = `Reads the current ${lowerFirst(subject)} collection.`;
  } else if (/Count$/.test(parsed.name) || parsed.name.startsWith("count")) {
    explanation = `Returns the current count for ${lowerFirst(subject.replace(/ Count$/, ""))}.`;
  } else if (parsed.name.startsWith("distance")) {
    explanation = "Calculates the current distance to the supplied world location.";
  } else if (parsed.name.startsWith("interact")) {
    explanation = `Requests the client interaction described by ${lowerFirst(subject.replace(/^Interact /, ""))}.`;
  } else if (parsed.name.startsWith("set")) {
    explanation = `Changes ${lowerFirst(subject.replace(/^Set /, ""))} to the supplied value.`;
  } else if (parsed.name.startsWith("walk")) {
    explanation = `Requests walker movement for ${lowerFirst(subject.replace(/^Walk /, ""))}.`;
  } else if (ACTION_PREFIXES.some((prefix) => parsed.name.startsWith(prefix))) {
    explanation = `Requests the ${lowerFirst(subject)} operation.`;
  } else {
    explanation = `Provides the ${lowerFirst(subject)} operation exposed by this type.`;
  }

  if (parsed.returnType.includes("Optional<")) {
    explanation += " No value is returned when no current match exists.";
  } else if (parsed.returnType.includes("List<")) {
    explanation += " The returned list may be empty.";
  } else if (parsed.returnType.includes("KLiteInteractionResult")) {
    explanation += " Inspect the interaction result before advancing the workflow.";
  }
  return explanation;
}

function returnExplanation(returnType) {
  if (!returnType) return "";
  const inner = returnType.match(/^CompletableFuture<(.*)>$/)?.[1] || returnType;
  if (inner === "Void") return "an asynchronous completion signal with no value";
  if (inner === "Boolean") return "an asynchronous true or false result";
  if (inner.includes("Optional<")) return "an asynchronous optional value; empty means no current match";
  if (inner.includes("List<")) return "an asynchronous list that may be empty";
  if (inner.includes("KLiteInteractionResult")) return "an asynchronous interaction outcome that should be checked";
  if (inner.includes("Snapshot")) return "an asynchronous point-in-time snapshot";
  return `an asynchronous ${inner} value`;
}

function typeDescription(type) {
  if (type.description?.trim()) return type.description.trim();
  if (TYPE_DESCRIPTIONS[type.name]) return TYPE_DESCRIPTIONS[type.name];
  const readable = humanize(type.name.replace(/^KLite/, "").replace(/Snapshot$/, "").replace(/Definition$/, ""));

  if (type.name.endsWith("Snapshot")) return `A read-only, point-in-time view of ${lowerFirst(readable)} state.`;
  if (type.name.endsWith("Definition")) return `Descriptive metadata for ${lowerFirst(readable)}, such as identity, name, actions, or configuration.`;
  if (type.name.endsWith("Request")) return `An input object used to describe a ${lowerFirst(readable)} request.`;
  if (type.name.endsWith("Result")) return `The outcome and status information produced by a ${lowerFirst(readable)} operation.`;
  if (type.name.endsWith("Status")) return `The current lifecycle or execution state for ${lowerFirst(readable)}.`;
  if (type.kind === "enum") return `A fixed set of supported ${lowerFirst(readable)} values.`;
  if (type.kind === "interface") return `A public contract for ${lowerFirst(readable)} behavior.`;
  if (type.kind === "record") return `An immutable data carrier for ${lowerFirst(readable)} information.`;
  return `A public KLite ${type.kind} used for ${lowerFirst(readable)} functionality.`;
}

function typeUsage(type) {
  if (type.name === "DefaultKLiteClientApi") return "Use it indirectly through dependency injection. Depend on KLiteClientApi so code remains easier to test and less coupled to the implementation.";
  if (type.name === "KLiteClientApi") return "Inject or receive this interface when plugin code needs client state, definitions, widgets, inventory containers, interactions, or client settings.";
  if (type.name.endsWith("Snapshot")) return "Use it after a snapshot-returning method completes. Request another snapshot before making decisions that require fresh state.";
  if (type.name.endsWith("Definition")) return "Use it when IDs alone are insufficient and the plugin needs metadata such as names or available actions.";
  if (type.name.endsWith("Request")) return "Construct it before calling the operation that accepts this request type.";
  if (type.name.endsWith("Result")) return "Read it immediately after an operation to decide whether to continue, retry, or recover.";
  if (type.kind === "enum") return "Pass one of its constants to methods that restrict a setting, mode, quantity, or state to supported values.";
  if ((type.signatures || []).length) return "Use its methods for the operations listed below. Prefer the most specific method that matches the task.";
  return "Use it as a value returned by, or supplied to, another public KLite API method.";
}

function humanize(value) {
  return value
    .replace(/([a-z0-9])([A-Z])/g, "$1 $2")
    .replace(/([A-Z]+)([A-Z][a-z])/g, "$1 $2")
    .replace(/_/g, " ")
    .replace(/\s+/g, " ")
    .trim()
    .replace(/^./, (character) => character.toUpperCase());
}

function lowerFirst(value) {
  return value ? value.charAt(0).toLowerCase() + value.slice(1) : value;
}

function capitalize(value) {
  return value ? value.charAt(0).toUpperCase() + value.slice(1) : value;
}

function escapeHtml(value) {
  return String(value)
    .replaceAll("&", "&amp;")
    .replaceAll("<", "&lt;")
    .replaceAll(">", "&gt;")
    .replaceAll('"', "&quot;")
    .replaceAll("'", "&#039;");
}

search.addEventListener("input", render);
sectionFilter.addEventListener("change", render);
kindFilter.addEventListener("change", render);
methodsOnly.addEventListener("change", render);
content.addEventListener("click", async (event) => {
  const button = event.target.closest(".api-copy-button");
  if (!button) return;
  try {
    await navigator.clipboard.writeText(button.dataset.signature || "");
    button.textContent = "Copied";
    window.setTimeout(() => { button.textContent = "Copy"; }, 1200);
  } catch {
    button.textContent = "Copy failed";
  }
});
logout.addEventListener("click", async () => {
  await request("/api/auth/logout", { method: "POST", body: "{}" });
  window.location.assign("/");
});
load();
