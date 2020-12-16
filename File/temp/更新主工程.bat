@echo off

cd /d "%~dp0"
cd "AppStore"
::set branc=AppStore/HiApp/Main
git branch -a
for /f "tokens=1,2" %%i in ('git branch') do if "%%i"=="*" set current=%%j
echo -----%CD%-----
cd
git stash
git checkout %branch%
git pull --rebase
git stash pop
echo.
for %i% in (
AppCommon
HiApp
HiAppBase
HiAppGame
HiAppTouch
WiseDist
WiseJoint
AppmarketSDK
) do (
	cd %%i
	echo -----%%i-----
	cd
	git stash
	git pull --rebase
	git stash pop
	echo.
	cd ..
)
echo -------------done-------------

pause