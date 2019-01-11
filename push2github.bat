@echo off

cd /d %cd%

git pull origin master
git add .
set /p description="Enter the log: "
git commit -m "%description%"
git push origin master
git pull origin master

pause