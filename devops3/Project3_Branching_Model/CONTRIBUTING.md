
# Contributing — Branching Model

## Quick Start
1. Branch from `main`: `git checkout -b feature/<ticket>-<desc> origin/main`
2. Keep PRs small (≤ 300 lines changed when possible).
3. Write or update tests.
4. Open PR early as draft to get feedback.
5. Squash merge into `main` after approvals and passing checks.

## Reviews
- Use CODEOWNERS to auto-request reviewers.
- Approvers ensure: scope is correct, tests cover changes, docs updated.

## Commit Style
Prefer Conventional Commits: `type(scope): message`
