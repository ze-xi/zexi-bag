@ECHO OFF
::----������������
@set reload=0
title ����Test-���������� -��������[%reload%] ���� ����By���� -��ǰʱ�䣺%date% %tm1% %TM2%
:reset
cls
::----���ÿ���ʹ����С�ڴ�
SET Min=2G
::----���ÿ���ʹ������ڴ�
SET Max=4G
::----���ÿ�����������
SET Server=Server1.12.2.jar
::----���ÿ����Ż����������������޸ģ���
SET Optimization=-XX:+UseG1GC
::----���Ӳ��� ��������Ҫ���벻Ҫ�޸ģ�(����)
SET Append= 
::----�Ƿ�������ģʽ
SET Dbug=0
::----�Ƿ�رպ��Զ�ɾ����־(�����ڴ�)
SET DeleteLog=0
cls
@echo. ---------------------------------------------------------------
@echo.[Server Configuration Info] - [ �������ؼ���ϢԤ�� ]
@echo.[Server Configuration Info] - [ ���ÿ�����С�ڴ棺%Min% ]
@echo.[Server Configuration Info] - [ ���ÿ�������ڴ棺%Max% ]
@echo.[Server Configuration Info] - [ ���ÿ�������Ϊ��%Server% ]
@echo.[Server Configuration Info] - [ ���ÿ����Ż�������%Optimization% ]
@echo.[Server Configuration Info] - [ ���ø��Ӳ�����%Append% ]
@echo.[Server Configuration Info] - [ �Ƿ�������ģʽ��%Dbug% ]
@echo. ---------------------------------------------------------------
java -Xms%Min% -Xmx%Max% %Optimization1% -jar %Server% %Append%
cls
@echo. 
@echo. ----------------------------------------------------------
@echo.              ���棺�������Ѿ�������ݱ���
@echo. ----------------------------------------------------------
@echo. 
if %Dbug% == 1 (
	@goto stop
)
choice /T 5 /D Y /M "��ѡ���Ƿ�����(5���Ӻ��Զ�����):"
if %errorlevel% == 1 (
	@echo. 
	@echo. ----------------------------------------------------------
	@echo.                     ������������������
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