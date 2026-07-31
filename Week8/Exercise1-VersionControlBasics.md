# Exercise 1: Version Control Concepts & Basic Git Commands

## Objective
Understand what version control is and why it matters, then practice the core local Git
workflow: `init`, `add`, `commit`, `status`, `log`.

## Concepts
- **Version control** tracks changes to files over time so you can review history, revert
  mistakes, and collaborate without overwriting each other's work.
- **Git** is a *distributed* version control system (DVCS) — every clone is a full repository
  with its own history, not just a checkout of a central server.
- **Git's three areas**:
  - **Working directory** — the files you're editing right now.
  - **Staging area (index)** — changes marked with `git add`, ready to be committed.
  - **Repository (.git folder)** — the committed history.

## Try it
```bash
mkdir git-practice && cd git-practice
git init                              # creates the .git folder — this is now a repo
git config user.name  "Dhruv Sharma"
git config user.email "dhruv@example.com"

echo "# Git Practice" > README.md
git status                            # README.md shows as "untracked"

git add README.md                     # stage it
git status                            # now shows as "staged"

git commit -m "Initial commit: add README"
git log                               # view commit history
git log --oneline --graph             # compact, visual history
```

## What to observe
- `git status` before and after `git add` — notice the file moves from "Untracked files" to
  "Changes to be committed".
- `git log` shows the commit hash, author, date, and message for every commit.

## Deliverable
A short screenshot/output log showing: `git init`, one `git add` + `git commit`, and the
resulting `git log --oneline`.
