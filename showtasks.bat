call runcrud.bat
if "%ERRORLEVEL%" == "0" goto openpage
echo Cannot open by Tomcat
goto fail

:openpage
start chrome.exe --new-window http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo Cannot open with Google Chrome
goto fail

:fail
echo.
echo runcrud.bat has errors - breaking work
echo There were errors

:end
echo.
echo Work is finished