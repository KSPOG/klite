const accountStatus = document.querySelector("#api-account-status");
const search = document.querySelector("#api-search");
const summary = document.querySelector("#api-summary");
const content = document.querySelector("#api-content");
const logout = document.querySelector("#api-logout");
let reference = null;

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
    summary.textContent = `${reference.typeCount} public types and ${reference.methodCount} callable signatures.`;
    render();
  } catch (error) {
    if (error.status === 401) {
      accountStatus.textContent = "Sign in on the marketplace to view the API reference.";
      content.innerHTML = '<a class="button button-primary" href="/?signin=1">Return to sign in</a>';
      search.disabled = true;
      return;
    }
    accountStatus.textContent = error.message;
  }
}

function render() {
  if (!reference) return;
  const query = search.value.trim().toLowerCase();
  content.replaceChildren();
  let visibleTypes = 0;
  for (const section of reference.sections || []) {
    const matching = (section.types || []).filter((type) => [
      type.name,
      type.packageName,
      type.description,
      ...(type.signatures || [])
    ].join(" ").toLowerCase().includes(query));
    if (!matching.length) continue;
    const heading = document.createElement("h2");
    heading.textContent = section.name;
    content.append(heading);
    for (const type of matching) {
      visibleTypes += 1;
      const details = document.createElement("details");
      details.className = "api-type";
      const title = document.createElement("summary");
      const name = document.createElement("strong");
      name.textContent = type.name;
      const kind = document.createElement("span");
      kind.textContent = type.kind;
      title.append(name, kind);
      const packageName = document.createElement("code");
      packageName.textContent = type.packageName;
      details.append(title, packageName);
      if (type.description) {
        const description = document.createElement("p");
        description.textContent = type.description;
        details.append(description);
      }
      for (const signature of type.signatures || []) {
        const block = document.createElement("pre");
        const code = document.createElement("code");
        code.textContent = signature;
        block.append(code);
        details.append(block);
      }
      content.append(details);
    }
  }
  if (!visibleTypes) content.textContent = "No API types match your search.";
}

search.addEventListener("input", render);
logout.addEventListener("click", async () => {
  await request("/api/auth/logout", { method: "POST", body: "{}" });
  window.location.assign("/");
});
load();
