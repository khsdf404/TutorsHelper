@echo off
git checkout main
git add .
set /P var="checked today: "
git commit -m "checked today: %var%"
git push
pause; 