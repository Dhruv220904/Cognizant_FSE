# Exercise 2: Branching and Merging

## Objective
Create and switch between branches, merge changes back into `main`, and resolve a merge
conflict on purpose so you recognize what one looks like.

## Concepts
- A **branch** is just a movable pointer to a commit — creating one is instant and cheap.
- `main` (or `master`) is typically the stable/production line; feature work happens on
  short-lived branches that get merged back in.

## Try it — create a branch and merge cleanly
```bash
cd git-practice
git branch feature/add-contact          # create the branch
git switch feature/add-contact          # move onto it (or: git checkout feature/add-contact)

echo "Contact: dhruv@example.com" >> README.md
git add README.md
git commit -m "Add contact info to README"

git switch main
git merge feature/add-contact           # fast-forward merge, no conflict
git log --oneline --graph --all
```

## Try it — cause and resolve a conflict
```bash
git switch main
echo "Version: 1.0" >> README.md
git commit -am "Set version to 1.0"

git switch feature/add-contact
echo "Version: 2.0" >> README.md        # same line, different branch
git commit -am "Set version to 2.0"

git switch main
git merge feature/add-contact           # CONFLICT (content): Merge conflict in README.md
```

Open `README.md` — Git marks the conflicting section:
```
<<<<<<< HEAD
Version: 1.0
=======
Version: 2.0
>>>>>>> feature/add-contact
```
Edit the file to keep the version you want, remove the `<<<<<<<`/`=======`/`>>>>>>>` markers,
then:
```bash
git add README.md
git commit -m "Merge feature/add-contact, resolve version conflict"
```

## Deliverable
The conflict markers you saw, and the resolved `README.md` after committing the merge.
