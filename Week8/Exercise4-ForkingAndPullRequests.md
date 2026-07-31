# Exercise 4: Forking and Pull Requests

## Objective
Fork someone else's repository, contribute a change on a branch, and open a pull request (PR)
back to the original — the standard open-source / team-collaboration workflow.

## Concepts
- A **fork** is your own copy of someone else's repository, under your GitHub account. You have
  full write access to your fork even if you don't have write access to the original.
- A **pull request** asks the original repo's maintainer to review and merge your changes from
  your fork/branch into their repo.

## Try it
1. On GitHub, open any public repo (e.g. a small sample project) and click **Fork** — this
   creates `github.com/<your-username>/<repo-name>`.
2. Clone *your fork* locally:
   ```bash
   git clone https://github.com/<your-username>/<repo-name>.git
   cd <repo-name>
   ```
3. Keep a reference to the original so you can stay in sync:
   ```bash
   git remote add upstream https://github.com/<original-owner>/<repo-name>.git
   git fetch upstream
   ```
4. Do the work on a branch (never directly on `main`):
   ```bash
   git switch -c fix/typo-in-readme
   # make your edit
   git add README.md
   git commit -m "Fix typo in installation instructions"
   git push -u origin fix/typo-in-readme
   ```
5. On GitHub, open your fork → you'll see a **"Compare & pull request"** banner for the branch
   you just pushed. Click it, write a description, and open the PR against the original repo's
   `main` branch.
6. If the original repo has moved on since you forked, sync before your PR gets stale:
   ```bash
   git fetch upstream
   git switch main
   git merge upstream/main
   git push origin main
   ```

## Deliverable
A link to (or screenshot of) an opened pull request from your fork's branch to the original
repository, including its title and description.
