#!/bin/bash
set -e

# 1. Create an empty commit on dev with the CI trigger message
git checkout dev
git commit --allow-empty -m "[fj] Trigger CI Dev version"
git push origin dev

# 2. Move to branch release
git checkout release

# 3. Merge dev into release
git merge dev --no-ff

git commit --allow-empty -m "[fj] Trigger CI Release"

# 4. Push release
git push origin release
