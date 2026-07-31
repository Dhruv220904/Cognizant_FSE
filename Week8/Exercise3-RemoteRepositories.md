# Exercise 3: Remote Repositories — Push and Pull

## Objective
Link a local repo to a remote one on GitHub, push local commits up, and pull remote changes
down, including tracking branches.

## Concepts
- A **remote** is a named reference to another copy of the repository (usually on GitHub) —
  `origin` is just the conventional name for "the main remote."
- `git push` sends local commits to the remote; `git pull` (= `fetch` + `merge`) brings the
  remote's commits into your local branch.
- A **tracking branch** remembers which remote branch it's linked to, so plain `git push` /
  `git pull` (no arguments) knows where to go.

## Try it
```bash
# On GitHub: create a new empty repository, e.g. "git-practice"

cd git-practice
git remote add origin https://github.com/<your-username>/git-practice.git
git remote -v                                  # confirm origin is set (fetch + push)

git push -u origin main                        # -u sets up tracking for future plain pushes
```

Make a change directly on GitHub (e.g. edit README.md in the browser and commit), then:
```bash
git pull origin main                            # bring that change down locally
```

Add multiple remotes (useful when working with a fork, covered in Exercise 4):
```bash
git remote add upstream https://github.com/<original-owner>/git-practice.git
git remote -v
```

Track a remote branch someone else pushed:
```bash
git fetch origin
git switch -c feature/from-remote origin/feature/from-remote
```

## Deliverable
Output of `git remote -v` after adding `origin` (and `upstream` if you tried the multi-remote
step), plus confirmation that a push and a pull each completed successfully.
