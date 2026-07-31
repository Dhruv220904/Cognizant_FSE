# Exercise 5: Git Collaboration Workflows

## Objective
Understand the common team workflows built on top of the branch/merge/remote mechanics from
Exercises 1–4, and pick the right one for a given team size and release cadence.

## Concepts

### 1. Centralized workflow
Everyone commits directly to `main` on a shared remote. Simple, but risky for anything beyond a
solo project or a very small, tightly coordinated team — no isolation between in-progress work.

### 2. Feature branch workflow
Every piece of work (feature, fix) gets its own branch off `main`, merged back via pull request
once reviewed. This is what Exercises 2–4 already practiced end-to-end:
```
main ──●──────────────●──── (stable, always deployable)
        \             /
         ●───●───●───●   feature/add-contact
```

### 3. Forking workflow
Same as feature-branch, but each contributor works in their *own* fork rather than branches on
the shared repo — standard for open-source projects where not everyone has write access
(Exercise 4).

### 4. Gitflow
A stricter branching model for projects with scheduled releases:
- `main` — production-ready code only.
- `develop` — integration branch for the next release.
- `feature/*` — branched from and merged back into `develop`.
- `release/*` — branched from `develop` when preparing a release; only bugfixes go here.
- `hotfix/*` — branched from `main` for urgent production fixes, merged into both `main` and
  `develop`.

```
main     ──●───────────────●───(hotfix)──●──
             \                          /
develop  ─────●────●────●────●────●────●──
               \        /
feature/x       ●──●──●
```

## Try it — simulate a feature-branch workflow end to end
```bash
cd git-practice
git switch main
git switch -c feature/add-license
echo "MIT License" > LICENSE
git add LICENSE
git commit -m "Add MIT license"
git push -u origin feature/add-license
# Open a PR on GitHub: feature/add-license -> main, review, then merge via the GitHub UI
git switch main
git pull origin main                 # bring the merged change back down locally
git branch -d feature/add-license    # clean up the now-merged local branch
```

## When to use which
| Team situation | Workflow |
|---|---|
| Solo project, low risk | Centralized |
| Small-to-mid team, continuous delivery | Feature branch |
| Open-source, external contributors | Forking |
| Scheduled releases, need hotfix isolation | Gitflow |

## Deliverable
A short write-up (2–3 sentences) naming which workflow you'd pick for a team of 5 shipping
weekly, and why — plus the command output from the "Try it" section above.
