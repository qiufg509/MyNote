@echo off

cd /d %cd%

git add .

set /p description="Enter the log: "
git commit -m "%description%"
git push origin master

pause