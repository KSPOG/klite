(() => {
  const menu = document.querySelector("#account-menu");
  const logout = document.querySelector("#account-menu-logout");
  if (!menu || !logout) return;

  const routes = [
    { id: "account-menu-community", label: "Community administration", route: "community", selector: "#discord-bot-dashboard" },
    { id: "account-menu-admin", label: "Marketplace administration", route: "admin", selector: "#owner-admin-dashboard, #review-dashboard" }
  ];
  let updatePending = false;

  function update() {
    updatePending = false;
    for (const definition of routes) {
      let button = menu.querySelector(`#${definition.id}`);
      if (!button) {
        button = document.createElement("button");
        button.id = definition.id;
        button.type = "button";
        button.setAttribute("role", "menuitem");
        button.textContent = definition.label;
        button.addEventListener("click", () => {
          menu.hidden = true;
          if (typeof setSiteRoute === "function") setSiteRoute(definition.route);
        });
        menu.insertBefore(button, logout);
      }

      const shouldHide = ![...document.querySelectorAll(definition.selector)]
        .some((panel) => !panel.hidden);
      if (button.hidden !== shouldHide) {
        button.hidden = shouldHide;
      }
    }
  }

  function scheduleUpdate() {
    if (updatePending) return;
    updatePending = true;
    requestAnimationFrame(update);
  }

  new MutationObserver(scheduleUpdate).observe(document.body, {
    subtree: true,
    childList: true,
    attributes: true,
    attributeFilter: ["hidden"]
  });
  update();
})();
