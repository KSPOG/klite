from pathlib import Path

INDEX = Path("marketplace-site/public/index.html")
HEADERS = Path("marketplace-site/public/_headers")
HEADER_PARTIAL = Path("scripts/release-preview/header.html")
HOME_PARTIALS = (
    Path("scripts/release-preview/home-1.html"),
    Path("scripts/release-preview/home-2.html"),
)


def replace_range(text: str, start: str, end: str, value: str) -> str:
    start_index = text.index(start)
    end_index = text.index(end, start_index)
    return text[:start_index] + value + text[end_index:]


def main() -> None:
    text = INDEX.read_text(encoding="utf-8")
    header = HEADER_PARTIAL.read_text(encoding="utf-8").rstrip()
    home = "\n".join(
        part.read_text(encoding="utf-8").rstrip() for part in HOME_PARTIALS
    ) + "\n\n"

    blocked_assets = (
        "announcement-shell.css",
        "announcement-hero.css",
        "announcement-cards.css",
        "announcement-docs.css",
        "release-preview.css",
        "obsidian-release.css",
        "homepage-featured.js",
    )
    text = "\n".join(
        line for line in text.splitlines()
        if not any(name in line for name in blocked_assets)
    )
    text = text.replace(
        "</head>",
        '  <link rel="stylesheet" href="/release-preview.css?v=3">\n'
        '  <link rel="stylesheet" href="/obsidian-release.css?v=1">\n'
        "</head>",
        1,
    )

    text = replace_range(
        text,
        '  <header class="site-header">',
        "  </header>",
        header,
    )
    while "  </header>  </header>" in text:
        text = text.replace("  </header>  </header>", "  </header>", 1)

    home_start = (
        '    <section class="landing-hero"'
        if '    <section class="landing-hero"' in text
        else '    <section class="release-home"'
    )
    text = replace_range(
        text,
        home_start,
        '    <section id="workspace-heading"',
        home,
    )
    text = text.replace(
        "</body>",
        '  <script src="/homepage-featured.js?v=1" defer></script>\n</body>',
        1,
    )

    required = (
        '/release-preview.css?v=3',
        '/obsidian-release.css?v=1',
        '/homepage-featured.js?v=1',
        'class="release-wordmark">KLite</h1>',
        'class="client-window"',
        'id="featured-plugin-list"',
        'id="workspace-heading"',
        'id="auth-dialog"',
    )
    missing = [token for token in required if token not in text]
    if missing:
        raise RuntimeError(f"Missing required homepage tokens: {missing}")
    if 'class="landing-hero"' in text:
        raise RuntimeError("Legacy landing hero was not removed")
    if "GPU Plugin" in text or "AFK Skiller" in text:
        raise RuntimeError("Placeholder marketplace cards remain")
    if "</header>  </header>" in text:
        raise RuntimeError("Duplicate header closing tag remains")

    INDEX.write_text(text.rstrip() + "\n", encoding="utf-8")

    headers = HEADERS.read_text(encoding="utf-8")
    for route in (
        "/release-preview.css",
        "/obsidian-release.css",
        "/homepage-featured.js",
        "/assets/obsidian-fractures.svg",
    ):
        if f"\n{route}\n" not in f"\n{headers}":
            headers += (
                f"\n{route}\n"
                "  Cache-Control: no-store, no-cache, must-revalidate, max-age=0\n"
                "  Pragma: no-cache\n"
                "  Expires: 0\n"
            )
    HEADERS.write_text(headers.rstrip() + "\n", encoding="utf-8")


if __name__ == "__main__":
    main()
