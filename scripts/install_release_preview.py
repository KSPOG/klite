from pathlib import Path

INDEX = Path("marketplace-site/public/index.html")
HEADERS = Path("marketplace-site/public/_headers")
HEADER_PARTIAL = Path("scripts/release-preview/header.html")
HOME_PARTIAL = Path("scripts/release-preview/home.html")


def replace_range(text: str, start: str, end: str, value: str) -> str:
    start_index = text.index(start)
    end_index = text.index(end, start_index)
    return text[:start_index] + value + text[end_index:]


def main() -> None:
    text = INDEX.read_text(encoding="utf-8")
    header = HEADER_PARTIAL.read_text(encoding="utf-8").rstrip()
    home = HOME_PARTIAL.read_text(encoding="utf-8").rstrip() + "\n\n"

    blocked_styles = (
        "announcement-shell.css",
        "announcement-hero.css",
        "announcement-cards.css",
        "announcement-docs.css",
        "release-preview.css",
    )
    text = "\n".join(
        line for line in text.splitlines()
        if not any(name in line for name in blocked_styles)
    )
    text = text.replace(
        "</head>",
        '  <link rel="stylesheet" href="/release-preview.css?v=3">\n</head>',
        1,
    )

    text = replace_range(
        text,
        '  <header class="site-header">',
        "  </header>",
        header,
    )

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

    required = (
        '/release-preview.css?v=3',
        'class="release-wordmark">KLite</h1>',
        'class="client-window"',
        'id="release-status"',
        'id="workspace-heading"',
        'id="auth-dialog"',
    )
    missing = [token for token in required if token not in text]
    if missing:
        raise RuntimeError(f"Missing required homepage tokens: {missing}")
    if 'class="landing-hero"' in text:
        raise RuntimeError("Legacy landing hero was not removed")

    INDEX.write_text(text.rstrip() + "\n", encoding="utf-8")

    headers = HEADERS.read_text(encoding="utf-8")
    route = "/release-preview.css"
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
