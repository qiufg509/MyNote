@echo off

cd /d %cd%

git pull origin develop
git add .
set /p description="Enter the log: "
git commit -m "%description%"
git push origin develop
git pull origin develop

pause