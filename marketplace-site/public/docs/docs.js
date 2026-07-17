const copyButtons = [...document.querySelectorAll("[data-copy-code]")];
const tocLinks = [...document.querySelectorAll(".docs-toc a")];
const documentedSections = tocLinks
  .map((link) => document.querySelector(link.getAttribute("href")))
  .filter(Boolean);

for (const button of copyButtons) {
  button.addEventListener("click", async () => {
    const code = button.closest(".code-block")?.querySelector("code")?.textContent || "";
    if (!code) return;

    const originalLabel = button.textContent;
    try {
      await navigator.clipboard.writeText(code);
      button.textContent = "Copied";
    } catch {
      button.textContent = "Copy failed";
    }
    window.setTimeout(() => { button.textContent = originalLabel; }, 1400);
  });
}

if ("IntersectionObserver" in window) {
  const observer = new IntersectionObserver((entries) => {
    const visible = entries
      .filter((entry) => entry.isIntersecting)
      .sort((left, right) => left.boundingClientRect.top - right.boundingClientRect.top)[0];
    if (!visible) return;

    for (const link of tocLinks) {
      const active = link.getAttribute("href") === `#${visible.target.id}`;
      link.classList.toggle("is-current", active);
      if (active) link.setAttribute("aria-current", "location");
      else link.removeAttribute("aria-current");
    }
  }, { rootMargin: "-18% 0px -70% 0px", threshold: [0, 0.1, 0.4] });

  for (const section of documentedSections) observer.observe(section);
}
