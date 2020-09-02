@ECHO OFF
::----设置重启次数
@set reload=0
title 冰子Test-正在制作中 -重启次数[%reload%] —— 冰云By冰子 -当前时间：%date% %tm1% %TM2%
:reset
cls
::----设置开服使用最小内存
SET Min=2G
::----设置开服使用最大内存
SET Max=4G
::----设置开服核心名字
SET Server=Server1.12.2.jar
::----设置开服优化参数，不懂请勿修改！！
SET Optimization=-XX:+UseG1GC
::----附加参数 无特殊需要，请不要修改！(废弃)
SET Append= 
::----是否开启调试模式
SET Dbug=0
::----是否关闭后自动删除日志(敬请期待)
SET DeleteLog=0
cls
@echo. ---------------------------------------------------------------
@echo.[Server Configuration Info] - [ 服务器关键信息预览 ]
@echo.[Server Configuration Info] - [ 设置开服最小内存：%Min% ]
@echo.[Server Configuration Info] - [ 设置开服最大内存：%Max% ]
@echo.[Server Configuration Info] - [ 设置开服核心为：%Server% ]
@echo.[Server Configuration Info] - [ 设置开服优化参数：%Optimization% ]
@echo.[Server Configuration Info] - [ 设置附加参数：%Append% ]
@echo.[Server Configuration Info] - [ 是否开启调试模式：%Dbug% ]
@echo. ---------------------------------------------------------------
java -Xms%Min% -Xmx%Max% %Optimization1% -jar %Server% %Append%
cls
@echo. 
@echo. ----------------------------------------------------------
@echo.              警告：服务器已经完成数据保存
@echo. ----------------------------------------------------------
@echo. 
if %Dbug% == 1 (
	@goto stop
)
choice /T 5 /D Y /M "请选择是否重启(5秒钟后自动重启):"
if %errorlevel% == 1 (
	@echo. 
	@echo. ----------------------------------------------------------
	@echo.                     正在重新引导启动。
	@echo. ----------------------------------------------------------
	@echo. 
	TIMEOUT /NOBREAK 3
	@set /a reload=%reload%+1
	@goto reset
	cls
) else (
	@goto stop
)
:stop