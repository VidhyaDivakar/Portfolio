# vidhyadivakar.com

Personal portfolio site. Built with Astro v5, deployed on Render.

## Stack

- Astro v5 (static output)
- Vanilla CSS — no frameworks
- Render for hosting, Cloudflare for DNS

## Structure

- `src/pages/` — all pages are standalone (no shared layout)
- `src/content/writing/` — experience entries
- `src/content/work/` — dev project entries
- `src/content/articles/` — published articles, backdated to original publish dates

## Local dev

```bash
npm install
npm run dev
```

Runs at `localhost:4321`.

## Deploy

Pushes to `main` auto-deploy via Render.
