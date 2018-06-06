@ECHO OFF
set file=inputs.txt
for /f "tokens=*" %%A in (%file%) do (java -jar "Ticketingsystem.jar" echo %%A) > outputs.txt
fc /b outputs.txt expectedoutputs.txt > nul
if errorlevel 1 (
    echo Test Failed!
) else (
    echo Test Passed!
)
pause