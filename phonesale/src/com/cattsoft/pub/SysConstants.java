package com.cattsoft.pub;

public class SysConstants {

	// ϵͳ����

	public static final String SYSTEM_PRPTY_CONTEXT_CONFIG_URL = "contextURL";
	
	public static final String SYSTEM_PRPTY_DAO_CONFIG_URL = "daoconfigURL";

	// ϵͳ�û���Ϊ��־��������
	public static final String LOG_ADD = "A"; // ���Ӳ���

	public static final String LOG_MOD = "M"; // �޸Ĳ���

	public static final String LOG_DELETE = "D"; // ɾ������
	
	public static final String LOG_CANCEL = "C"; // ���ò���

	//
	public static final String ACTIVITY = "ACTIVITY"; 
	public static final String YES = "1";

	public static final String NO = "0";

	public static final String TRUE = "Y";

	public static final String FALSE = "N";

	public static final String PARTY_ROLE_TYPE_ID = "7";// Ա����ɫ����

	// ���ַ���
	public static final String NULL_STRING = "";

	// ���ú�ע��
	public static final String USE_YES_STS = "A";

	public static final String USE_NO_STS = "P";

	// ���������˵���ʽ
	public static final String SO_RETURN_TYPE = "1";// 1:������ 0��������

	// ��������
	public static final String STEP_FOR_SO_FINISH = ""; // 

	public static final String ONE = "1";

	// �쳣����
	public static final String EXP_CODE = "EXP_CODE";

	public static final String EXP_MSG = "EXP_MSG";

	// ϵͳ�ص���
	public static final String SYS_RT_STAFF_ID = "999999999";
	//ϵͳ�ص�������
	public static final String SYS_RT_STAFF_NAME = "ϵͳ";

	// ϵͳ�ص��˲���
	public static final String SYS_RT_DEPT_ID = "999999999";

	public static final String SYS_DEFAULT_USER_ID = "40009";

	// ��ѯ��������
	public static final String SYS_ROW_LIMIT = "21009";

	// ����ˢ�µ�ַ

	public static final String DATA_CACHE_REFRESH_ADDR = "21012";

	/** ****************************************ϵͳ����************************************* */
	// �������
	public static final String BULLETIN_TYPE_B = "B";// ϵͳ����
	public static final String BULLETIN_TYPE_S = "S";// ��������
	
	// ����
	public static final String ATTACHMENT_FOR_SCENE_B = "B";// ��������Ӧ�ĸ���
	

	/** ****************************************������************************************* */

	public static final String SO_COUNT_IN_CO = "1"; //co����so����
	
	public static final String REC_SO_COUNTS = "1";  //co�Ѿ����յ���so��
	
	public static final String COMPL_FLAG = "N"; 
	
	public static final String CO_NBR_SEQ = "CO_NBR";
	
	/** ������ݲ�ѯ ��������id */
	public static final String SYS_CONFIG_CO_QUICK_QUERY = "71010";
	
	// ---------------SO_BOOK
	public static final String SO_BOOK_WO_STS_WAIT = "D";// �ȴ�����

	public static final String SO_BOOK_WO_STS_DOING = "P";// ���ڴ���

	public static final String SO_BOOK_WO_STS_COMPLETE = "C";// �������

	public static final String SO_BOOK_METHOD_NAME_FOR_ADD = "addSoBook";

	public static final String SO_BOOK_METHOD_NAME_FOR_MOD = "updateSoBook";

	public static final String SO_BOOK_METHOD_NAME_FOR_CANCLE = "cancleBook";
	
	public static final String SO_BOOK_CRM = "34102";
	
	public static final String EXPT_TYPE_SO_BOOK = "5"; //�������� 5 ԤԼ���

	public static final String SO_BOOK_XML = "SO_BOOK_XML"; // ԤԼ��ϢXML
	
	public static final String RET_STRING_ARR = "RET_STRING_ARR"; // ԤԼ���ص�������Ϣ
	//������Դ
	public static final String SO_RES_SYSTEM_SELF = "SELF";
	public static final String SO_RES_SYSTEM_CRM = "CRM";
	public static final String SO_RES_SYSTEM_RMS = "RMS";
	public static final String SO_RES_SYSTEM_IVR = "IVR";
	
	

	//MSG_QUEUE.MSG_TYPE
	public static final String MSG_TYPE_SEND = "MT";  //msg_queue.msg_type ϵͳ���͵���Ϣ
	
	public static final String MSG_TYPE_RECE="MO";//msg_queue.msg_type ϵͳ���յ���Ϣ
	
	public static final int MSG_QUEUE_HANDLE_COUNT=3;//msg_queue.msg_type ϵͳ���յ���Ϣ

	public static final String MSG_QUEUE_HANDLE_Flag_W = "W";// �ȴ�����

	public static final String MSG_QUEUE_HANDLE_Flag_C = "C";// �������

	public static final String MSG_QUEUE_HANDLE_Flag_F = "F";//����ʧ��

	//MSG_RECEIVE_QUEUE

	public static final String MSG_RECEIVE_QUEUE_STS_D = "D";// �ȴ�����

	public static final String MSG_RECEIVE_QUEUE_STS_C = "C";// �������

	public static final String MSG_RECEIVE_QUEUE_STS_F = "F";//����ʧ��
	
	
	//���Żص�ָ��
	public static final String SP_MSG_ORDER_CGHD="SPCGHD";//����ͨ�ɹ��ص�
	public static final String MSG_ORDER_CGHD="CGHD";//�ɹ��ص�
	
	public static final String MSG_ORDER_SBHD="SBHD";//ʧ�ܻص�
	
	public static final String MSG_ORDER_CP="CP";//��������
	
	public static final String MSG_ORDER_JDFK="JDFK";//���ȷ���
	
	public static final String MSG_ORDER_ZP="ZP";//ת��
	
	public static final String MSG_ORDER_JP="JP";//����
	
	public static final String MSG_ORDER_LD = "LD"; // �쵥
	
	
	// ����STS
	public static final String SO_CHANGE_GROUP_STS = "B";// �ȴ�����

	// ����״̬
	public static final String SO_WAIT_UPD_CANCEL = "K";// �ȴ�����

	public static final String SO_SUSPEND = "s";// ��װ

	public static final String SO_GIVEWAY = "h";// ����������

	public static final String SO_MODIFY = "g";// �ĵ�������

	public static final String DEAL_FLAG_REVERSE = "1";// ����

	public static final String DEAL_FLAG_DIRECT = "0";// ����

	public static final String SO_BIDE = "Y";// ��װ

	public static final String SO_PROCESSING = "P";// ����������

	public static final String SO_EXPLORATION = "V";// �⿰

	public static final String SO_RETURN_FAIL = "F";// �˵�������

	public static final String SO_BE_ABOUT_TO = "A";// ����

	public static final String SO_WAIT_CHOICE_PROC = "W";// �ȴ�ѡ������

	public static final String SO_MATCH_FAIL = "M";// ģ��ƥ��ʧ��

	public static final String SO_WAIT_START = "D";// �ȴ���������

	public static final String SO_START_ERROR = "E";// ��������ʧ��

	public static final String SO_FUTILITY = "R";// ʧЧ

	public static final String SO_FINISH = "C";// ��������

	public static final String SO_WORK_FINISH = "S";// ʩ������

	public static final String SO_WAIT_SO_CANCEL = "B";// �ȴ�ԭ������
	
	public static final String SO_AUDIT = "T";// ��Ҫ���
	
	public static final String SO_STS_TEMP = "t";// ��ʼ¼��
	
	// Эͬ״̬
	public static final String COLLAB_STS_PROC_WAIT = "W";// ����Эͬ�ȴ�

	public static final String COLLAB_STS_STEP_WAIT = "S";// ����Эͬ�ȴ�

	public static final String COLLAB_STS_NOMOR = "N";// ����

	public static final String REAL_TIME_FLAG_YES = "Y";//
	
	public static final String REAL_TIME_FLAG_JMS = "J";//

	public static final String REAL_TIME_FLAG_NO = "N";//


	// ��������
	public static final String SO_TYPE_FUTILITY = "1";// ע����

	public static final String SO_TYPE_MODIFY = "2";// �޸ĵ�

	public static final String SO_TYPE_NORMAL = "0";// ������

	public static final String SO_TYPE_FOR_WAIT = "3";// ��װ��

	public static final String SO_TYPE_FOR_AGAIN = "4";// ��װ��

	public static final String SO_TYPE_FOR_CHANGE_GROUP = "5";// �ĵ���Ⱥ��

	// �����ص���ʽ
	public static final String WO_RET_SUCCESS = "0";// �����ص�

	public static final String WO_RET_FAIL = "1";// ʧ�ܻص�
	
	public static final String WO_RET_CODE_FOR_PARALLEL_WO = "WO_RET_CODE_FOR_PARALLEL_WO"; //���ڲ��й���δ���������ܻص�
	
	public static final String WO_RET_SUCCESS_BOTH = "2";// �����ʹӵ���һ�������ص�

	// �����Ĵ���ʽ
	public static final int BIDE_TYPE = 1;// ��װ����ʽ

	// ������ִ�з�ʽ
	public static final String SO_AUTO_EXEC = "A";// �Զ���������

	public static final String SO_UN_AUTO_EXEC = "M";// �˹�ѡ������

	// ����������
	public static final String GROUP_FLAG_FOR_YES = "Y";// ���־

	public static final String GROUP_FLAG_FOR_NO = "N";// �����־

	// �˵������־
	public static final String CANCEL_FLAG_FOR_NO = "1";// ������

	public static final String CANCEL_FLAG_FOR_YES = "0";// ����

	// ���÷�ʽ
	public static final String CALL_FLAG_FOR_JAVA = "J";// JAVA����

	public static final String CALL_FLAG_FOR_PROCDURE = "P";// �洢���̵���

	// INTER_CALL_CONFIG�ĵ���ʱ��
	public static final String INTER_CALL_CONFIG_CALL_POINT_BUILD = "D";

	public static final String INTER_CALL_CONFIG_CALL_POINT_FETCH = "P";

	public static final String INTER_CALL_CONFIG_CALL_POINT_RET = "C";

	public static final String INTER_CALL_CONFIG_CALL_POINT_UNABLE = "R";

	// �洢���̵��÷���ֵ
	public static final String CALL_PROCEDURE_RET_VALUE = "VALUE";// ����ֵ

	public static final String CALL_PROCEDURE_RET_STATUS = "RET_STATUS";// ����״̬

	public static final String CALL_PROCEDURE_RET_DESC = "RET_DESC";// ��������

	// ԤԼ��־
	public static final String BOOK_FLAG_FOR_YES = "Y"; // ԤԼ

	public static final String BOOK_FLAG_FOR_NO = "N"; // ��ԤԼ

	public static final String BOOK_TASK_NUM = "6"; // ���͹�����

	// ��������״̬
	public static final String SO_LOCK_STS_NO = "N";// δ����

	public static final String SO_LOCK_STS_YES = "Y";// ����

	public static final String SO_LOCK_STS_CANCEL_SO = "H";// ��������

	public static final String SO_LOCK_STS_CHANGE_SO = "G";// �ĵ�����

	public static final String SO_LOCK_STS_DELAY_SO = "S";// ��װ����
	
	public static final String SO_LOCK_STS_RELATE_SO = "R";// ���Ϲ�������

	// ���ù������ķ�ʽ
	public static final String CALL_TYPE_FOR_START_PROCESS = "0";// ��������

	public static final String CALL_TYPE_FOR_FAIL_REASON = "1";// ��������

	// ��Ϣ�����־ MSG_FLAG
	public static final String SO_MSG_FLAG_NOT_PROCESS = "0";// 0 ��δ����

	public static final String SO_MSG_FLAG_SUCCESS_PROCESS = "1";// 1 ����ɹ�

	public static final String SO_MSG_FLAG_FAIL_PROCESS = "2";// 2 ����ʧ��

	// SO_RES�����־
	public static final String ASSIGN_FLAG_RES_ASSIGN = "Y";// Y ��Դ�������

	public static final String ASSIGN_FLAG_CRM_ASSIGN = "N";// N ����Я������

	// SO_RES���ұ�־
	public static final String SO_RES_IS_SELF_YES = "Y";// Y ��

	public static final String SO_RES_IS_SELF_NO = "N";// N �񣬹�����

	// SO SO_
	public static final String SO_SEQ_DEFAULT = "0";

	// �շ�״̬ PAY_STS C1 Y
	public static final String SO_PAY_STS_YES = "Y";// Y ���շ�

	public static final String SO_PAY_STS_NO = "N";// N δ�շ�

	// �Ƿ��Ѿ�ȷԤԼ ACCU_FLAG
	public static final String ACCU_FLAG_YES = "Y";// �Ѿ�ȷԤԼ

	public static final String ACCU_FLAG_NO = "N";// δ��ȷԤԼ

	// �ߵ���־ HASTEN_FLAG N Y �У�֮ǰ��Դ�����ߵ�
	public static final String HASTEN_FLAG_YES = "Y";

	public static final String HASTEN_FLAG_NO = "N";

	// ͳһ�����ӿڷ��ؽ��
	public static final String RET_NAI_SUCCESS = "C";// �ɹ�

	public static final String RET_NAI_FAIL = "F";// ʧ��

	public static final String RET_NAI_CONTINUE = "N";// ������ת

	public static final String RET_NAI_TO_MANUAL = "M";// ��Ҫת�˹�����

	// �ص��ӿ��������̵Ĳ���ʵ��
	public static final String WORK_FLOW_PARAMETER_PROD_ID = "PROD_ID";

	public static final String WORK_FLOW_PARAMETER_BUSI_ID = "BUSI_ID";

	public static final String WORK_FLOW_PARAMETER_EXP_ID = "EXP_ID";

	public static final String WORK_FLOW_PARAMETER_PRIORITY = "PRIORITY";

	public static final String WORK_FLOW_PARAMETER_LOCAL_NET = "LOCAL_NET_ID";

	// ������ʽ
	public static final String METHOD_TRIGER_YES = "Y"; // ҵ����򴥷�

	// �������̴����ؽ��
	public static final String SO_PROC_RET_CODE = "PROC_RET_CODE"; // add at

	// 08.07.25
	// by
	// huangyx
	

	/** ************************������**************************************************************************** */
	// ����ҵ��״̬
	
	public static final String BUSI_STS_DELAY = "H";// ��װ
	
	public static final String BUSI_STS_BIDE = "Y";// ��װ

	public static final String BUSI_STS_NORMAL = "N";// ����

	public static final String BUSI_STS_FAIL = "F";// ʧ�ܻص�

	public static final String BUSI_STS_AUDIT = "A";// �ȴ����

	public static final String BUSI_STS_STAY = "S";// ʧ������

	public static final String BUSI_STS_REMOKE = "K";// �ȴ�����

	public static final String BUSI_STS_FAIL_INVOKE = "I";// ����ʧ��

	// ʩ����ʽ
	public static final String WO_WORK_MODE_MANUAL = "M"; // �˹�

	public static final String WO_WORK_MODE_AUTO = "A"; // �Զ�

	public static final String WO_WORK_MODE_AUTO_MANUAL = "AM"; // �˹��Զ�

	// ʩ��������������
	public static final String TAB_COLUMN_COL_TYPE_NUMBER = "N";// ��ֵ��

	public static final String TAB_COLUMN_COL_TYPE_DATE = "D";// ������

	public static final String TAB_COLUMN_COL_TYPE_STRING = "S";// �ַ�����

	// ��������״̬
	public static final String RUN_STS_PROCESSING = "P";// ������

	public static final String RUN_STS_COMPLETE = "C";// ���

	public static final String RUN_STS_WAIT_PROCESS = "D";// �ȴ�����

	public static final String RUN_STS_WAIT_RETURN = "W";// �ȴ�����

	public static final String RUN_STS_REVOKE = "R";// �Ѿ�����

	public static final String RUN_STS_DISP_FAIL = "I";// ����ʧ��

	// �����־
	public static final String DIRECTION_FORWORD = "0";// ����

	public static final String DIRECTION_INVERT = "1";// ����

	// �쳣ԭ��
	public static final String FAIL_REASON_EXCEPTION_INVOKE_TO_CRM = "1040110";// �˵�����쳣ǰ����CRM

	public static final String FAIL_REASON_TO_BE_INSTALLED = "20003001";// ��װת������ȷ��ԭ��

	public static final String FAIL_REASON_TO_BE_INSTALLED_CONFIRM = "20003002";// ��װת����Ҫȷ��ԭ��
	
	public static final String SYS_CONFIG_IS_GET_DEFAULT_WORK_AREA = "46010";// ��װ���Ƿ��ɵ�Ĭ�Ϲ���

	public static final String FAIL_REASON_SPECIAL_OVERTIME_REASON = "20002001";// ��������ԭ��
	
	public static final String FAIL_REASON_DELAY_FIX_ID = "20003003";// ��װ
	
	public static final String FAIL_REASON_REVERT_WO = "1000000";// ����ǿ�з���
	
	public static final String FAIL_REASON_REASSIGN_WO = "1000100";// ��������ת��������֧
	
	// �˵�ԭ������
	public static final String FAIL_REASON_FOR_FAIL = "A";// ʧ��

	public static final String FAIL_REASON_FOR_EXP = "K";// �⿱

	public static final String FAIL_REASON_FOR_WAIT = "C";// ��װ��ȷ��

	public static final String FAIL_REASON_FOR_BIDE = "W";// ��װ����ȷ��
	
	public static final String FAIL_REASON_FOR_WAIT_H = "Z"; // �˹���λ��װ����װת����ֱ��ԭ�ں������̣������ظ��ɷ�ת��װ��λ�Ĺ���
	
	public static final String FAIL_REASON_DELAY_FIX = "H";// ��װ

	public static final String FAIL_REASON_FOR_OVER = "B";// ����

	public static final String FAIL_REASON_FOR_COLLAB = "J";// Э����
	
	public static final String FAIL_REASON_FOR_TRANSFER = "D";// Э����
	
	public static final String FAIL_REASON_FOR_HANDLE_RATE = "P"; //���ȸ���
	
	public static final String FAIL_REASON_FOR_REPAIR_WAY = "R"; //�޸����������ڷ�����ϵͳ�����޸�

	// �����ʶ
	public static final String STEP_REVERSE_FLAG_YES = "Y"; // ���뷴��

	public static final String STEP_REVERSE_FLAG_NO = "N"; // ���뷴��

	// ��˱�־
	public static final String STEP_FAIL_REASON_AUDIT_FLAG_AUDIT = "Y";// ��Ҫ���

	public static final String STEP_FAIL_REASON_AUDIT_FLAG_NOT_AUDIT = "N";// �������

	// �����쳣������
	public static final String STEP_FAIL_REASON_FAIL_DO_FLAG_NEED_AUDIT = "A";// ��Ҫ���

	public static final String STEP_FAIL_REASON_FAIL_DO_FLAG_WAIT_WITHDRAW = "K";// �ȴ�����

	public static final String STEP_FAIL_REASON_FAIL_DO_FLAG_FAIL_RETURN = "F";// ʧ�ܻص�

	public static final String STEP_FAIL_REASON_FAIL_DO_FLAG_FAIL_STAY = "S";// ʧ������

	public static final String STEP_FAIL_REASON_FAIL_DO_FLAG_CONTINUE = "C";// �ճ���ת

	public static final String STEP_FAIL_REASON_FAIL_DO_FLAG_MANUAL = "M";// �쳣�˹�����

	// ���ڻص���־
	public static final String STEP_BACK_FLAG_ALLOW = "Y"; // ����ص�

	public static final String STEP_BACK_FLAG_REFUSE = "N";// �ܾ��ص�

	public static final String STEP_CANCEL_FLAG_ALLOW = "Y";// ������

	public static final String STEP_CANCEL_FLAG_REFUSE = "N";// ��������

	public static final String STEP_CANCEL_FLAG_PART = "P";// ����״̬��������ܾ�����

	// ���ڶ�Ӧ�Զ������ص�����
	public static final char STEP_MANUAL_U = 'U';// ������ɹ��ص���������ʧ�ܻص�

	public static final char STEP_MANUAL_S = 'S';// ����ɹ��ص���������ʧ�ܻص�

	public static final char STEP_MANUAL_F = 'F';// ������ɹ��ص�������ʧ�ܻص�

	public static final char STEP_MANUAL_A = 'A';// ����ɹ��ص�������ʧ�ܻص�

	// ���ڻ����־
	public static final String STEP_SPEC_PRPTY_ALLOW = "Y";// �������

	public static final String STEP_SPEC_PRPTY_REFUSE = "N";// �������

	public static final String STEP_SPEC_PRPTY_COMPONENT_CODE_PVC = "SO_PVC"; // pvc����ؼ�

	public static final String STEP_SPEC_PRPTY_COMPONENT_CODE_CIRCUIT = "SO_CIRCUIT";// ��·����ؼ�

	public static final String STEP_SPEC_PRPTY_COMPONENT_CODE_EQPT = "SO_EQPT_PRPTY";// �ն��豸����ؼ�

	public static final String STEP_SPEC_PRPTY_COMPONENT_CODE_MAIN_PROD_PRPTY = "SO_MAIN_PROD_PRPTY";// ����Ʒ���Ի���ؼ�

	public static final String STEP_SPEC_PRPTY_COMPONENT_CODE_SUB_PROD_PRPTY = "SO_SUB_PROD_PRPTY";// ������Ʒ���Ի���ؼ�

	public static final String STEP_SPEC_PRPTY_COMPONENT_CODE_RES_FILL = "RES_FILL";// ��Դ��

	public static final String STEP_SPEC_PRPTY_COMPONENT_CODE_SO_PRPTY = "SO_PRPTY";// �������Ի���
	
	public static final String STEP_SPEC_PRPTY_FILL_MODE_A = "A";// �Զ�����
	
	public static final String STEP_SPEC_PRPTY_FILL_MODE_M = "M";// �˹�����
	
	public static final String STEP_SPEC_PRPTY_FETCH_MODE_S = "S";// ��̬ȡֵ
	
	public static final String STEP_SPEC_PRPTY_FETCH_MODE_D = "D";// ��̬ȡֵ
	

	// ��ǰ�û���Ϊʩ����Ա
	public static final String STEP_WO_STAFF_BY_SESSION = "D";

	// ���ݹ���ѡ��ʩ����Ա
	public static final String STEP_WO_STAFF_BY_WORK_AREA = "W";

	// ���ݰ���ѡ��ʩ����Ա
	public static final String STEP_WO_STAFF_BY_MAIN_AREA = "M";

	// ���ݹ����Ͱ���ѡ��ʩ����Ա
	public static final String STEP_WO_STAFF_BY_BOTH = "S";

	// ���ͨ����־
	public static final String PASS_AUDIT = "Y";// ���ͨ��

	public static final String UN_PASS_AUDIT = "N";// ��˲�ͨ��

	// ϵͳ��ʶ
	public static final String SYSTEM_CRM = "CRM";// �ۺϿͷ�ϵͳ

	public static final String SYSTEM_SPS = "SPS";// ����ͨ

	public static final String SYSTEM_RMS = "RMS";// ��Դϵͳ

	public static final String SYSTEM_NAS = "NAS";// ���缤��ϵͳ
	
	public static final String SYSTEM_BILLING = "Billing";// �Ʒ�ϵͳ

	public static final String SOURCE_SYS_A = "A";// CRM
	
	public static final String SOURCE_SYS_B = "B";// ����Ӫҵ��

	public static final int DEFAULT_PAGE_SIZE = 50;
	
	public static final int DEFAULT_PAGE_NUM = 10;

	public static final int DEFAULT_PAGE_SIZE_FOR_WORETURN = 50;// ʩ���������ÿҳ��ʾ��¼��

	// ��������
	public static final String TWO = "2";// 

	// ��������
	public static final String WO_TYPE_FOR_RETURN = "B";// �˵�

	public static final String WO_TYPE_FOR_SURVEY = "P"; // �⿱��

	public static final String WO_TYPE_FOR_BIDE = "Y"; // ��װ��

	public static final String WO_TYPE_FOR_NEED_PROC = "H"; // �޵�

	public static final String WO_TYPE_FOR_COLLAB = "C"; // Э����

	public static final String WO_TYPE_FOR_MOINITOR = "S"; // ���쵥

	public static final String WO_TYPE_FOR_GO_BACK = "F"; // ׷��

	public static final String WO_TYPE_FOR_NORMAL = "N"; // ������
	
	public static final String WO_PRESS_REMARKS="�Զ��ɷ��Ĵߵ�";
	
	// ҵ��״̬
	public static final String WO_BUSI_STS_NORMAL = "N";// ����

	// ����״̬
	public static final String WO_RUN_STS_FOR_PERFORM = "P";// ������

	public static final String WO_RUN_STS_FOR_COMPLETED = "C";// �����

	public static final String WO_RUN_STS_FOR_CANCLE = "R";// ����

	public static final String WO_RUN_STS_FOR_WAIT = "D";// �ȴ�����

	// ��ע
	public static final String WO_REMARKS_WO_RESEND = "�����ط�";

	// ������־
	public static final String HALT_FLAG_FOR_UN_HALT = "N"; // û������

	// ��̬��־
	public static final String DYN_FLAG_FOR_YES = "Y"; // ��̬

	public static final String DYN_FLAG_FOR_NO = "N"; // �Ƕ�̬

	// �ɵ���ʽ
	public static final String TABLE_NAME_FOR_EXCH_ID = "E"; // ������

	public static final String TABLE_NAME_FOR_LOCAL_NET_ID = "L"; // ��������

	public static final String TABLE_NAME_FOR_AREA_ID = "A"; // ��������

	public static final String TABLE_NAME_FOR_SWITCH_ID = "S"; // ��������

	public static final String TABLE_NAME_FOR_MDF_ID = "M"; // �����߼�

	public static final String TABLE_NAME_FOR_CCP_ID = "C"; // ���ս�����

	public static final String TABLE_NAME_FOR_SERV_DEPT_ID = "D"; // ����Ӫά

	public static final String TABLE_NAME_FOR_SPEC_PRPTY = "P"; // ���ղ�Ʒ����
	
	public static final String TABLE_NAME_FOR_MAINT_AREA_ID = "W"; // ������
	
	public static final String TABLE_NAME_FOR_WORK_AREA_PRPTY = "Y"; // ������

	// ��������

	public static final String ACT_TYPE_FOR_LOAD = "A"; // װ

	public static final String ACT_TYPE_FOR_REMOVE = "R"; // ��

	public static final String ACT_TYPE_FOR_UNCHANGE = "X";// ����(���ϵ�Ϊ�޵�)
	
	public static final String ACT_TYPE_FOR_MODIFY = "M"; //�޸�

	// ��������
	public static final String AR_FLAG_LOAD = "A"; // װ

	public static final String AR_FLAG_REMOVE = "P"; // ��

	// ���ӵ���־
	public static final String MAIN_FLAG_FOR_MAIN = "M"; // ����

	public static final String MAIN_FLAG_FOR_SUITE = "S"; // �ӵ�

	// �ϵ���־
	public static final String MERG_FLAG_YES = "Y"; // �Ѻϲ�

	public static final String MERG_FLAG_NO = "N"; // δ�ϲ�

	public static final String MERG_FLAG_NOTNEED = "W"; // ����ϲ�

	// �����Ա�־
	public static final String FULL_FLAG_FOR_ALL = "C"; // �ӵ�

	// ԤԼ֪ͨ��ʽ
	public static final String NOTIFY_FLAG_FOR_YES = "Y"; // �Ѿ�֪ͨ

	public static final String NOTIFY_FLAG_FOR_NO = "N"; // δ֪ͨ

	// ���������־

	public static final String MSG_FLAG_NO_PROCESS_ = "0"; // û�д���

	public static final String MSG_FLAG_PROCESS_SUCCESS = "1"; // ����ɹ�

	public static final String MSG_FLAG_PROCESS_FAIL = "2"; // ����ʧ��

	public static final String WO_RET_CODE_SUCCESS = "1";// �ص��ɹ�

	public static final String WO_RET_CODE_FAIL = "0";// �ص�ʧ��
	
	// ���������˽ӿڷ��ش���ʽ
	public static final String EXP_WO_DEAL_MODE_P = "P";// ֻ������
	
	public static final String EXP_WO_DEAL_MODE_R = "R";// ֻ�跴��
	
	public static final String EXP_WO_DEAL_MODE_PR = "PR";// ��������Ҫ
	
	public static final String EXP_WO_DEAL_MODE_NPNR = "NPNR";// �Ȳ���Ҫ����Ҳ����Ҫ���� 
	
	public static final String WO_ITEM_CAT_H ="H";//��װ���
	
	public static final String WO_ITEM_CAT_Y ="W";//�⿰���
	
	public static final String WO_ITEM_STS_P ="P";//��װת��״̬
	
	public static final String WO_ITEM_STS_C ="C";//��װת��״̬
	
	public static final String WO_ITEM_STS_Y ="Y";//����ʩ��
	
	public static final String WO_RES_SYSTEM ="SPS";//������ ��Դϵͳ Ĭ��SPS



	/** *************************��ͨ������*********************************** */

	// ʩ������ƥ��
	public static final String STEP_TEMPLATE_FOR_SCENE_R = "R"; // ����������
	
	public static final String STEP_TEMPLATE_FOR_SCENE_W = "W"; // �����������
	
	public static final String STEP_TEMPLATE_FRO_SCENE_B = "B"; // ���Ի���
	
	// �������(spec_prpty)for_scene
	public static final String SPEC_PRPTY_FOR_SCENE_PWC = "PWC"; // ����������
	
	public static final String SPEC_PRPTY_INPUT_FLAG_D = "D";//��ɢֵ
	
	public static final String SPEC_PRPTY_INPUT_FLAG_I = "I";// ����ֵ

	public static final String SPEC_PRPTY_INPUT_FLAG_S = "S";// ��ɢֵ��4��ʹ�ã�

	// ��������
	public static final String STEP_TYPE_FOR_SYSTEM = "SC"; // ϵͳ�

	public static final String STEP_TYPE_FOR_ACCEPT = "SO"; // ����

	public static final String STEP_TYPE_FOR_SERVICE_DEVISE = "SD"; // �������

	public static final String STEP_TYPE_FOR_RESOUSE_ALLOCATE = "RA"; // ��Դ����

	public static final String STEP_TYPE_FOR_SERVICE_CONFIG = "SP"; // ��������

	public static final String STEP_TYPE_FOR_SERVICE_ACTIVE = "SA"; // ���񼤻�
	
	public static final String STEP_TYPE_FOR_WORKFLOW_REBUILD ="WR"; // �����ع�
	
	public static final String STEP_TYPE_FOR_FREE_FLOW = "FF"; // ��������

	// ���������־
	public static final String PLUS_FLAG_FOR_NORMAL = "0"; // ����

	public static final String PLUS_FLAG_FOR_UN_NORMAL = "1"; // ������

	// ��������
	public static final String PLUS_TYPE_FOR_SURVEY = "E"; // �⿰

	public static final String PLUS_TYPE_FOR_BIDE = "W"; // ��װ

	// ����Эͬ����ϵ���־
	public static final String MERG_FLAG_FOR_NEED = "Y"; // ��Ҫ�ϵ�

	public static final String MERG_FLAG_FOR_UN_NEED = "N"; // ���ϵ�

	// �����ϵ���־
	public static final String MERG_FLAG_FOR_ALREADY_MERGE = "Y"; // �Ѿ��ϵ�

	public static final String MERG_FLAG_FOR_NO_MERGE = "N"; // ��û�кϵ�

	public static final String MERG_FLAG_FOR_NO_NEED_MERGE = "W"; // ����ϵ�

	// ƥ������ MATCH_TYPE

	public static final String MATCH_TYPE_BUSI_RULE = "R";// R ҵ�����

	public static final String MATCH_TYPE_SYS_ITEM = "P";// P ϵͳԪ��

	// ����� MATCH_OPERATOR
	public static final String MATCH_OPERATOR_EQUAL = "=";// = ���ڣ�

	public static final String MATCH_OPERATOR_UNEQUAL = "!=";// != �����ڣ�

	public static final String MATCH_OPERATOR_MORE_THAN = ">";// > ���ڣ�

	public static final String MATCH_OPERATOR_MORE_THAN_AND_EQUAL = ">=";// >=���ڵ��ڣ�

	public static final String MATCH_OPERATOR_LESS_THAN = "<";// < С�ڣ�

	public static final String MATCH_OPERATOR_LESS_THAN_AND_EQUAL = "<=";// <=С�ڵ���

	public static final String MATCH_OPERATOR_INCLUDE = "IN";// IN ������

	public static final String MATCH_OPERATOR_NOT_INCLUDE = "NOT IN";// NOT

	// ���ö���ģ��ƥ�� FOR_SO_MATCH C1 NULL Y Y ����N ������
	public static final String FOR_SO_MATCH_YES = "Y";

	public static final String FOR_SO_MATCH_NO = "N";

	// ���ر�־
	public static final String OPEN_FLAG_OPEN = "O";// O ���ã���

	public static final String OPEN_FLAG_CLOSE = "C";// C ���ã��ر�

	// �Ƿ�һ��Ʒ SIMPLE_PROD_FLAGM �����Ʒ���Эͬ��S ������Ʒ��Эͬ��eg����Ե��������æ�����ȡ�
	public static final String SAME_PROD_FLAGM_SIMPLE = "S";

	// ���ı�־ CANCEL_FLAG
	public static final String CANCEL_FLAG_YES = "Y";// ������

	public static final String CANCEL_FLAG_NO = "N";// ��������

	// ����״̬ CANCEL_STS
	public static final String CANCEL_STS_TO_ALL = "0";// ����״̬

	public static final String CANCEL_JUDGE_RULE_INCLUDE = "I";// I

	// ������ָSTEP_CANCEL_RULE�ж����״̬��ϽԿɳ���

	public static final String CANCEL_JUDGE_RULE_EXCLUDE = "E";// E

	// �ų���ָSTEP_CANCEL_RULE�ж����״̬��ϲ��ɳ���

	// ���Ĳ�Ʒҵ���ʶ
	public static final String PROD_CHANGE_FLAG_YES = "Y";

	// ���ڻ������Ա��У��ֶ�COMPONENT_CODEΪ����Ʒʱ��ȡֵ
	public static final String SO_MAIN_PROD_PRPTY = "SO_MAIN_PROD_PRPTY";

	public static final String SO_PRPTY_COMPONENT_CODE = "SO_PRPTY"; //������������

	// ���ڻ������Ա��У��ֶ�COMPONENT_CODEΪ������Ʒʱ��ȡֵ
	public static final String SUB_PROD_PRPTY = "SO_SUB_PROD_PRPTY";

	// ���ڻ������Ա��У��ֶ�COMPONENT_CODEΪ�ն��豸��ʱ��ȡֵ
	public static final String SO_EQPT_PRPTY = "SO_EQPT_PRPTY";
	
//	 ���ڻ������Ա��У��ֶ�COMPONENT_CODEΪpwcר�ߵ�·����ʱ��ȡֵ
	public static final String SO_PWC_PRPTY = "SO_PWC_PRPTY";

	// ���ڻ������Ա��У��ֶ�COMPONENT_CODEΪ��Դ��ʱ��ȡֵ
	public static final String RES_FILL = "RES_FILL";

	public static final String SO_CIRCUIT = "SO_CIRCUIT";

	public static final String SO_PVC = "SO_PVC";
	
	//ʵʱ���д����� Y ���� N ͣ��
	public static final String PARALLEL_YES = "Y";

	public static final String PARALLEL_NO = "N";

	/** *******************ʩ������ҳ��*************************************************** */
	// ʩ������ҳ��
	public static final String Wo_RETURN = "WoReturn";// �ص�ҳ��

	public static final String WO_FETCH_UNBOOK = "WoFetchUnBook";// �쵥δԼҳ��

	public static final String WO_FETCH_BOOK = "WoFetchBook";// �쵥ԤԼҳ��

	public static final String WO_PRESS = "WoPress";// �ߵ�ҳ��

	public static final String WO_EXCEPTION = "WoException";// �쳣����ҳ��

	public static final String WO_CC = "WoCc"; // ���͹���ҳ��
	
	public static final String WO_TRACK = "WoTrack";//��������
	
	/** *************������Ӧ����ҳ�涨��**************************************************** */
	public static final String WO_SUCCESS_RETURN = "PopWoSuccessReturn";//�ɹ��ص�
	
	public static final String WO_SEND_TO = "PopWoSendTo";//ת��
	
	public static final String WO_NOTIFY = "PopWoNotify";//����֪ͨ
	
	public static final String WO_FAIL_RETURN = "PopWoFailReturn";//ʧ�ܻص�
	
	public static final String WO_FETCH_UN_BOOK = "PopWoFetchUnBook";//�쵥δԼ
	
	public static final String COMPONENT_CODE_SUCCESS_RETURN = "successReturnComp";//�ɹ��ص���Ϣ�ؼ�
	
	public static final String COMPONENT_CODE_FAIL_RETURN = "FailReturnComp";//ʧ�ܻص���Ϣ�ؼ�
	
	public static final String COMPONENT_CODE_WOATTACHMENT = "woAttachmentComp";//�����ϴ��ؼ�
	
	public static final String COMPONENT_CODE_FETCH_UNBOOK = "fetchUnBookComp";//�쵥��Ϣ�ؼ�
	
	public static final String COMPONENT_CODE_FETCH_PRINT = "fetchPrintComp";//�쵥��ӡ�ؼ�
	
	public static final String COMPONENT_CODE_FILL_SO_PRPTY = "fillSoPrpty";//�������Ի���ؼ�
	
	public static final String COMPONENT_CODE_FAULT_TEST = "faultTestComp";//���ϲ��Կؼ�
	
	public static final String COMPONENT_CODE_FAULT_HANDLE = "faultHandleComp"; //���ϴ���ؼ�
	
	public static final String COMPONENT_CODE_FAULT_CONFIRM = "faultConfirm"; //����֤ʵ�ؼ�
	
	public static final String COMPONENT_CODE_FAULT_DETERMINE = "faultDetermineComp"; // ���϶��Կؼ�
	
	public static final String COMPONENT_CODE_ALLOW_RETURN_SO_NBR="allowReturnSoNbr"; //����ص�
	public static final String COMPONENT_CODE_SO_TEST_RESULT="soTestResultCompl";     //���Խ���ؼ�
	public static final String  COMPONENT_CODE_SA_WO_SEND_TO="saWoSendTo";         //ת�ɿؼ�
	public static final String  COMPONENT_CODE_WO_REASSIGN="woReassignComp";       //�������̼�����ת�ɿؼ�
	
	public static final String COMPONENT_CODE_MSG_NOTIFY= "WoMsgNotifyComp"; //���ſؼ�
	public static final String COMPONENT_CODE_WO_STAFF = "stepWoStaffComp";//����ʩ���˿ؼ�
	

	/** **************************sysconfig���õ�����******************************************* */
	// sysconfig���õ�����
	public static final String SYS_CONFIG_PORT_ID = "215044";// �����豸�˿�id
	public static final String SYS_CONFIG_PWC_NBR_ID = "215045";// ר�ߺ�id
	public static final String SYS_CONFIG_PWC_SPEED_ID = "215046";// ����id
	
	public static final String SYS_CONFIG_TYPE_PROVINCE = "G";// ȫʡͳһ������
	public static final String SYS_CONFIG_TYPE_LOCALNET = "L";// ������ͳһ������

	public static final String SYS_CONFIG_TYPE_AREA = "A";// ������ͳһ������

	public static final String SYS_CONFIG_TYPE_WORKAREA = "W";// ������ͳһ

	public static final String SYS_CONFIG_TYPE_EXCH = "E";// ����ͳһ

	public static final String SYS_CONFIG_TYPE_WORKTYPE = "T";// ����������

	public static final String SYS_CONFIG_EXPORT_EXCEL_RECORD = "70003"; // ��������ҳ��excel��¼����

	public static final String SYS_CONFIG_EXCEL_FILEPATH = "40003"; // ����EXCEL�ڷ������ϵ��ļ�·��������

	public static final String SYS_CONFIG_BOOK_DUE_TIME = "34000";// ԤԼ��������ʱ��

	public static final String SYS_CONFIG_IS_CHECK_STEP_SPEC_PRPTY = "34010";// �ص�ʱ���Ƿ񰴻���У�����Ի���ı�����
	
	// add by xieyunchao 20120626����Ҫ��ͳһ����ϵͳ������һ�����������ӵ�����ͨ�����ڼ���ͳһ�����ͷ���ͨ�õ���ͬһ�״��룬
	//Ϊ�������Ƿ���ҳ������ʾ�����ӣ�������һ����־,���ΪY������ʾ���ӡ�
	public static final String SYS_CONFIG_SHOW_LINK = "215039";
	public static final String SYS_CONFIG_LINK_TO_SP_IP_PORT = "215040";//ͳһ�������ӵ�����ͨ��ip��ַ�Ͷ˿ں�
	
	public static final String SYS_CONFIG_OUT_TIME = "110033";// ��ʱʱ������

	public static final String SYS_CONFIG_SHARE_LINE = "34004";// ���߱���

	public static final String SYS_CONFIG_MAIN_PROD = "34003";// ��������Ʒ

	public static final String SYS_CONFIG_NUM_RES_SERV = "34005";// ������Դ�������

	public static final String SYS_CONFIG_LINE_RES_SERV = "34006";// ��·��Դ�������

	public static final String SYS_CONFIG_PORT_RES_SERV = "34007";// �˿���Դ�������

	public static final String SYS_CONFIG_IP_RES_SERV = "34008";// IP��Դ�������

	public static final String SYS_CONFIG_RES_PRPTY_PHYACCNBR = "34030";// ��Դ�����������

	public static final String SYS_CONFIG_RES_PRPTY_ACCNBR = "34031";// ��Դ�����߼�����

	public static final String SYS_CONFIG_RES_PRPTY_DISTNBR = "34032";// ��Դ�����߼���������

	public static final String SYS_CONFIG_RES_PRPTY_PHYDISTNBR = "34033";// ��Դ�����߼���������

	public static final String SYS_CONFIG_RES_PRPTY_MDFPORT = "34034";// ��Դ�������߼ܺ���

	public static final String SYS_CONFIG_RES_PRPTY_MDFEPAIR = "34035";// ��Դ�������߼ܺ��ж���

	public static final String SYS_CONFIG_RES_PRPTY_MDFEIPAIR = "34036";// ��Դ���Ի��������˶���

	public static final String SYS_CONFIG_RES_PRPTY_MDFEOPAIR = "34037";// ��Դ���Ի�����г��˶���

	public static final String SYS_CONFIG_RES_PRPTY_MDFNAME = "34038";// ��Դ���Ի������߼�����

	public static final String SYS_CONFIG_RES_PRPTY_MDFDPAIR = "34039";// ��Դ�������߼�1ֱ�ж���

	public static final String SYS_CONFIG_RES_PRPTY_IPADDR = "34040";// ��Դ����IP��ַ

	public static final String SYS_CONFIG_RES_PRPTY_SUBMASK = "34041";// ��Դ������������

	public static final String SYS_CONFIG_RES_PRPTY_GATEWAY = "34042";// ��Դ��������

	public static final String SYS_CONFIG_RMS_DELAY_URL = "40000";// ����Դ��ַ

	public static final String SYS_CONFIG_RMS_DELAY_METHOD = "40030";// ����Դ��ַ

	public static final String SYS_CONFIG_PATH_EXCEL_SAVE = "40003";// excel����·��

	public static final String SYS_CONFIG_JRE_DOWNLOADS_URL = "40005"; // jre���ص�ַ

	public static final String SYS_CONFIG_FLASH_DOWNLOADS_URL = "40025"; // flash���ص�ַ

	public static final String SYS_CONFIG_SLA_URL = "40017";

	public static final String SYS_CONFIG_MAINTAREA_OF_ZJ = "10000000";// ����������ʩ��ƽ̨

	public static final String SYS_CONFIG_MAINTAREA_STEP = "SP0015";// ����ͨϵͳ�쳣

	public static final String SYS_CONFIG_IS_CHECK_STEP_SPEC_PRPTY_CHECK = "Y";
	
	public static final String REASON_CAT_FOR_NO_RESOURCE = "O";// ��װ����Դԭ��

	public static final String REASON_CAT_FOR_CUSTOM_REASON = "U";// ��װ�ͻ�ԭ��
	
	public static final String WO_TYPE_FOR_BIDE_NO_RESOURCE = "R"; // ��װ�����ַ�ԭ��

	public static final String WO_TYPE_FOR_BIDE_CUSTOM_REASON = "U"; // ��װ�����ͻ�ԭ��

	public static final String SYS_CONFIG_BIDE_WORK_AREA_ID = "34012";// ����Ĵ�װ����

	public static final String SYS_CONFIG_RETURN_AUTO = "40006";// �Զ���λ�Ƿ���Իص�

	public static final String SYS_CONFIG_FETCH_AUTO = "40007";// �Զ���λ�Ƿ�����쵥

	public static final String SYS_CONFIG_ATTACH_SO_FLAG = "71001";// �����ϴ����ܿ���

	public static final String SYS_CONFIG_COPY_TO_BUTTON_FLAG = "71002";// �������͹��ܿ���
	
	public static final String SYS_CONFIG_MAINTAREA_CHECK = "34018"; // �ɹ��ص�ʱ�Ƿ���б���ά������У�� liyaquan
	
	public static final String SYS_CONFIG_STEP_CHECK = "34028"; //�ɹ��ص��Ƿ���л��ڵ�У�� liyaquan
	
	public static final String SYS_CONFIG_SO_CAT_FLAG = "71013";// �Ƿ���ʾ���ϵ� longbijin
	
	public static final String SYS_CONFIG_SPEED_FLAG = "21015";//�Ƿ��߼Ʒ�ͣ��ʵʱͨ�� ronghengen
	
	public static final String SYS_CONFIG_PARALLEL_FLAG = "21025";//ʵʱ���д����� caiqian
	
	public static final String SYS_CONFIG_SYNC_RES_PROCEDURE_FLAG = "34019";//ͬ����Դ�Ĵ洢���̵Ŀ��� yangkai
	
	public static final String SYS_CONFIG_RES_ASGN_REQ_PROD_PRPTY = "34069";//��Դ��������ʱ��Ҫ���ݸ���Դ�Ĳ�Ʒ����id
	
	//�ҵ������ѯ����������
	public static final String BUSI_RULE_ID_SEND_ORDER_BY_PRPTY = "10000008";//�������ɵ��Ĺ���ID; liyaquan
	
	public static final String SYS_CONFIG_TASK_NUM = "71012";

	public static final String SYS_CONFIG_ASSIGN_BY_CENTER = "34020";// ����Ӫά�����ɵ�

	public static final String SYS_CONFIG_ASGN_DEVICE_FAIL_TO_EXCH = "34021";// ���豸�ɵ�ʧ�ܸİ������ɵ�

	public static final String IS_CAN_RES_CHANGE = "40010"; // ��Դ���ʱ�Ƿ���Ҫ����У��

	public static final String SYS_CONFIG_USER_QUERY_URL = "40008";// �Զ���λ�Ƿ�����쵥

	public static final String SYS_CONFIG_MODI_MAINTAREA = "34017"; // ����ά�������Ĺ���������

	public static final String SYS_CONFIG_CO_GROUP = "34013";// COȺ�µĶ����Ƿ�һ������

	public static final String SYS_CONFIG_START_PROCESS_TYPE = "45000";// �������������ж�

	public static final String SYS_CONFIG_GROUP_SPEC_ID = "46000";// ���й��߹�ϵ��Ⱥ����ID

	public static final String SYS_CONFIG_FOR_INAS = "90010";// ʵʱ����ͨ�Ƿ����NASģ��ӿ�����

	public static final String SYS_CONFIG_FOR_INAS_YES = "Y";// ʵʱ����ͨ����NASģ��ӿ�����
	
	public static final String SYS_CONFIG_IS_REWRITE_NBR = "34060";// �Ƿ��д��Դ�ɺ�����Ϣ shilei
	
	public static final String SYS_CONFIG_CHK_WG_WORK_TYPE = "40060"; //��Ҫ��������Ĺ���(ɽ��)

	public static final String NUM_RES_SERV = "101";// ������Դ�������

	public static final String LINE_RES_SERV = "301";// ��·��Դ�������

	public static final String PORT_RES_SERV = "201";// �˿���Դ�������

	public static final String IP_RES_SERV = "102";// IP��Դ�������

	public static final String RMS_DELAY_URL = "40000";// ����Դ��ַ

	public static final String SYS_CONFIG_MAINT_AREA_ISNEED = "34016";//  

	public static final String SYS_CONFIG_CAN_CHANGE_WO_STAFF = "40011";// �Ƿ����ѡ��ʩ����Ա

	public static final String SYS_CONFIG_RES_USED_QUERY = "40013";// �����û���Դ��ѯ��ַ

	public static final String SYS_CONFIG_RES_USED_CHANGE = "40014";// �����û���Դ�����ַ
	
	public static final String SYS_CONFIG_RES_USED_ADDR = "215000";// ��׼��ַ��ѯ  add by liyaquan
	
	public static final String SYS_CONFIG_RES_CHANGE = "40026";// ��Դ������õ�ַ
	
	public static final String SYS_CONFIG_RES_IN_PROCESS = "40027";// ��;����Դ��ѯ���õ�ַ
	
	public static final String SYS_CONFIG_RES_CHANGE_EXCH_WO = "40033";// ��Դ�򲹾����Ƿ�ȡ��������

	public static final String SYS_CONFIG_RES_DETAIL_INFO = "40015";// ��Դ��ϸ��Ϣչ�ֵ�ַ

	public static final String SYS_CONFIG_USER_OTHER_QUERY_URL = "40016";// �����û�������ѯ

	public static final String SYS_CONFIG_NUMBER_USE_QUERY_URL = "40020";// CRM����ʹ�ò�ѯ

	public static final String SYS_CONFIG_CRM_MOD_PWD_URL = "21008";// crm�޸��û�����ĵ�ַ

	public static final String SYS_CONFIG_CRM_MOD_PWD_JSP_URL = "21010";// crm��У���Ƿ��һ�ε�½��ʱ���޸������jspҳ���ַ

	public static final String SYS_CONFIG_CRM_RESET_PWD_URL = "21011";// crm

	public static final String SYS_CONFIG_SPS_QUERT_COUNT = "44000";// ���ӷ���ͨ������ѯ��������ѯ��ʩ������߼���ѯ������ѯ����

	public static final String SYS_CONFIG_PORT_CONVERT_URL = "40021";// ������Դ�˿ڶ��յ��������

	public static final String SYS_CONFIG_FILE_SIZE = "70010";// �����ϴ���С����

	public static final String SYS_CONFIG_SO_MODIFY = "71005";// �����޸Ĺ��ܿ�������

	public static final String SYS_CONFIG_SO_PRIORITY = "71011";// ���ȼ����ƹ��ܿ�������
	
	public static final String SYS_CONFIG_IS_SHOW_MSG = "71020";// �����ɵ�Ĭ���Ƿ���ʾ��Ϣ����
	
	public static final String SYS_CONFIG_SHOW_MSG = "71021";// �쵥ҳ���Ƿ���ʾ������Ϣ�Ĺ���
	
	public static final String SYS_CONFIG_CHECK_CODE = "21030";// ��½ҳ���Ƿ���ҪУ����
	
	public static final String SYS_CONFIG_CHECK_CODE_YES = "Y";// 
	
	public static final String SYS_CONFIG_CHECK_CODE_NO = "N";// 
	
	//public static final String WO_ATTACHMENT_COMP = "woAttachmentComp";// �����ϴ��ؼ�

	public static final String SYS_CONFIG_PRESSPRECENT = "71022"; //�ߵ��ɷ�TIMER�ɷ��ߵ�ʱ��������

	public static final String SYS_CONFIG_ISCREATEPRESSWO = "71023"; //�ߵ��ɷ�TIMER�Ƿ����ɴߵ�,����ֱ���ɷ�����
	
	// ���ڹ����ɷ����ţ�����Ԥ��ʱ���Ƿ��ɷ�����
    public static final String SYS_CONFIG_NRMS_IS_QUERY_PRE_ALARM_DATE = "80030";

	// �������õķ�����ַ

	public static final String SYS_CONFIG_FIRST_PASSWORD = "21000";// ϵͳ��ʼ������12ab!@

	public static final String SYS_CONFIG_STEP_NOT_CANCLE_OR_CHANGE = "40017";// ��������Ѿ�����ĳЩ���ڣ���������

	public static final String SYS_CONFIG_FILTER_USER = "50003";// �����û�

	public static final String SYS_CONFIG_IS_SYN_PAY_CHARGE = "40019"; // �Ƿ����CRM�շ�״̬ͬ��

	public static final String SYS_CONFIG_IS_SYN_PAY_CHARGE_FOR_NO = "N";

	public static final String SYS_CONFIG_TIMER_REALTIMEFRESH = "90001"; // Timerʵʱ������Ϣ

	public static final String SYS_CONFIG_IS_EJB_REMOTE = "21014"; // ����ϵͳejb���÷�ʽ

	public static final String SYS_CONFIG_RELEASED_VERSION = "90002"; // ����ͨ�����汾

	public static final String SYS_CONFIG_CHG_SERV_SPEC_LIST = "35000"; // ��Դ��ѯ���ز����¾�������¼�Ŀͻ������б�

	public static final String SYS_CONFIG_RES_RELEASE_STEP = "90003"; // ���������Դ�ͷŵĻ����б�

	public static final String SYS_CONFIG_GROUP_CHANGE_FAILRETURN_REASON_ID = "90004"; // "Ⱥ����������Ա�����˻�Ӫҵ"�쳣ԭ��ID

	public static final String SYS_CONFIG_ROUTER_CHECK = "33000"; // �ɹ��ص�ʱ�Ƿ����·�����У��

	public static final String SYS_CONFIG_CUSTOM_NAME_HB_CUCC = "100000"; // �ͻ�����,
																			// ������Բ�ͬ�Ŀͻ���Ʒ,���ֹ��ܺͷ��

	public static final String SYS_CONFIG_CUSTOM_TYPE = "99999"; // ���
																	// CUCC:�й���ͨ
																	// CTG���й�����

	public static final String SYS_CONFIG_SYS_INFO_NUM = "90005";// ϵͳ����,���ڿ���ϵͳ��Ϣ��ʾ������.

	public static final String SYS_CONFIG_RELEASED_SMALL_VERSION = "90006"; // ����ͨ����С�汾
	
	public static final String SYS_CONFIG_SPS_URL = "22000";// SPS��URL

	public static final String SYS_CONFIG_SGS_URL = "22001";// SGS��URL

	public static final String SYS_CONFIG_WORKFORCE_URL = "22002";// WORKFORCE��URL

	public static final String SYS_CONFIG_INAS_URL = "22003";// INAS��URL

	public static final String SYS_CONFIG_RMS_URL = "22004";// RMS��URL

	public static final String SYS_CONFIG_PROCESS_ID = "36000";// ���������Ĭ������ID

	public static final String SYS_CONFIG_EXP_DATE = "36001";// ��������Ĭ��ʧЧʱ��
	
	public static final String SYS_CONFIG_MAIL_HOST_NAME = "81010";//�����ʼ�����������
	
	public static final String SYS_CONFIG_SEND_MAIL_NAME = "81020";//���÷������ʼ���ַ
	
	public static final String SYS_CONFIG_INTERFACE_LOCAL_VISION = "82010"; // ���ؽӿڰ汾����
	
	public static final String SYS_CONFIG_FLEX_WEBSTART = "40100";// �����������չ�ַ�ʽwebstart/flex���ƿ���
	
	public static final String SYS_CONFIG_FLEX = "FLEX";//�����������չ�ַ�ʽ:flex

	public static final String SYS_CONFIG_FIND_HIS = "36002";// ������ѯ��������ѯ����ʷ��ѯ����ѡ���Ƿ���ʾ
	
	public static final String SYS_CONFIG_ASSIGN_CCP = "3000008";// һ��������id
	
	public static final String SYS_CONFIG_ASSIGN_CCP_NAME = "3000010";// һ������������
	public static final String SYS_CONFIG_ASSIGN_ZGDL = "3000021";// ���ɵ��±��
	
	public static final String SYS_CONFIG_ASSIGN_DEVICETYPE = "200";// ���������ɵ�
	
	public static final String SYS_CONFIG_ASSIGN_DEVICESUBTYPE = "20021";// ���������ɵ�

	/** ************************************************SEQ********************************************* */

	// SEQ
	
	public static final String SERV_DEPT_STOP_CONFIG_ID_SEQ = "SERV_DEPT_STOP_CONFIG_ID";

	public static final String ATTACHMENT_ID_SEQ = "ATTACHMENT_ID";//�������ɵ� add by caiqian 20100224
	
	public static final String WORK_AREA_PRPTY_ID_SEQ = "WORK_AREA_PRPTY_ID";//�������ɵ� add by liyq 2009-9-22
	
	public static final String MSG_ITEM_ID_SEQ = "MSG_ITEM_ID";// ��Ϣ���Ԫ��
	
	public static final String NWORK_DAY_ID_SEQ = "NWORK_DAY_ID";// �ڼ���
	
	public static final String MATERIAL_ID_SEQ = "MATERIAL_ID"; // ���ϻ���
	public static final String MSG_SEQ = "MSG";// ��Ϣ���Ԫ��

	public static final String SO_TEMPLATE_ID_SEQ = "SO_TEMPLATE_ID";

	public static final String PKG_GRP_RELA_ID_SEQ = "PKG_GRP_RELA_ID";

	public static final String INTER_CALL_CONFIG_ID_SEQ = "INTER_CALL_CONFIG_ID";

	public static final String SO_MATCH_ID_SEQ = "SO_MATCH_ID";

	public static final String SO_PROCESS_ID_SEQ = "SO_PROCESS_ID";

	public static final String FAIL_REASON_ID_SEQ = "FAIL_REASON_ID";// �쳣ԭ������

	public static final String STEP_REASON_ID_SEQ = "STEP_REASON_ID";
	
	public static final String STEP_TEMPLATE_ID_SEQ = "STEP_TEMPLATE_ID";//ʩ��ģ��ƥ��

	public static final String STEP_FACTOR_ID_SEQ = "STEP_FACTOR_ID";

	public static final String COLLAB_RULE_ID_SEQ = "COLLAB_RULE_ID";// Эͬ��������

	public static final String COLLAB_RULE_BUSI_ID_SEQ = "COLLAB_RULE_BUSI_ID";// Эͬ����ҵ������

	public static final String WORK_TYPE_ID_SEQ = "WORK_TYPE_ID";// ������������

	public static final String WO_HANDLE_CUSTOM_SEQ = "WO_HANDLE_CUSTOM";// ʩ��������涨������

	public static final String QUERY_CONFIG_ID_SEQ = "QUERY_CONFIG_ID";// ��ѯ����

	public static final String INTER_SERVICE_ORDER_ID_SEQ = "INTER_SERVICE_ORDER_ID";// ���񶨵��ӿڱ�����

	public static final String PROCESS_COLLAB_RULE_ID_SEQ = "PROCESS_COLLAB_RULE_ID";// ����Эͬ������

	public static final String STEP_COLLAB_RULE_ID_SEQ = "STEP_COLLAB_RULE_ID";// ����Эͬ������

	public static final String SO_BOOK_ID_SEQ = "SO_BOOK_ID";// ����ԤԼ���

	public static final String SO_CHARGE_ID_SEQ = "SO_CHARGE_ID";// ����������Ϣ���

	public static final String SPJK_PARA_ID_SEQ = "SPJK_PARA_ID"; // �ӿڲ������

	public static final String WO_NBR_SEQ = "WO_NBR";// ��������
	
	

	public static final String CUST_ORDER_ITEM_ID_SEQ = "CUST_ORDER_ITEM_ID";// �ͻ�������ϸ

	public static final String CUST_ORDER_BUSINESS_ID_SEQ = "CUST_ORDER_BUSINESS_ID";// �ͻ���������񶨵���ϵ

	public static final String SO_SI_GROUP_MEMBER_ID_SEQ = "SO_SI_GROUP_MEMBER_ID";// ��������ʵ�����Ա

	public static final String SO_SI_GROUP_ID_SEQ = "SO_SI_GROUP_ID";// ��������ʵ����

	public static final String SO_RELA_ID_SEQ = "SO_RELA_ID";// ����������Ϣ

	public static final String SO_MAIN_PROD_ID_SEQ = "SO_MAIN_PROD_ID";// ��������Ʒ��Ϣ

	public static final String SO_PRICE_PLAN_ID_SEQ = "SO_PRICE_PLAN_ID";// �����۸�ƻ����

	public static final String SO_SUB_PROD_ID_SEQ = "SO_SUB_PROD_ID";// ����������Ʒ��Ϣ���

	public static final String SO_ACC_NBR_ID_SEQ = "SO_ACC_NBR_ID";// ��������ʵ�����

	public static final String SO_ADDR_ID_SEQ = "SO_ADDR_ID";// ������ַ���

	public static final String SO_CHANGED_ID_SEQ = "SO_CHANGED_ID"; // �����䶯��Ϣ���

	public static final String SO_EQPT_PROD_ID_SEQ = "SO_EQPT_PROD_ID";// �����ն��豸��Ϣ���

	public static final String SO_EQPT_PRPTY_ID_SEQ = "SO_EQPT_PRPTY_ID";// �����ն��豸������Ϣ���
	
	public static final String SO_PRPTY_ID_SEQ = "SO_PRPTY_ID";//�������Ա��

	public static final String SO_MAIN_PROD_PRPTY_ID_SEQ = "SO_MAIN_PROD_PRPTY_ID";// ��������Ʒ������Ϣ���

	public static final String SO_MAIN_PROD_PRPTY_EXT_ID_SEQ = "SO_MAIN_PROD_PRPTY_EXT_ID";// ����Ʒ������չ���

	public static final String SO_SUB_PROD_PRPTY_ID_SEQ = "SO_SUB_PROD_PRPTY_ID";// ����������Ʒ������Ϣ���

	public static final String SO_SUB_PROD_PRPTY_EXT_ID_SEQ = "SO_SUB_PROD_PRPTY_EXT_ID";// ����������Ʒ������չ���

	public static final String SO_PROD_PAUSE_ID_SEQ = "SO_PROD_PAUSE_ID";// ������Ʒͣ����Ϣ���

	public static final String SO_CUST_ID_SEQ = "SO_CUST_ID";// �����ͻ���Ϣ���

	public static final String WO_HANDLE_SEQ = "WO_HANDLE_ID";// ����������¼��

	public static final String MSG_ID_SEQ = "MSG_ID";// ����ƥ����Ϣ SO_MSG_CENTER

	public static final String ACTION_LOG_SEQ = "ACTION_ID";// ����ƥ����Ϣ

	public static final String INTER_MSG_CENTER_ID_SEQ = "INTER_MSG_ID";// ����������Ϣ��

	public static final String STEP_COLLAB_INST_ID_SEQ = "STEP_COLLAB_INST_ID";// ����Э������ʵ�����

	public static final String PROCESS_COLLAB_INST_ID_SEQ = "PROCESS_COLLAB_INST_ID";// ����Э������ʵ�����

	public static final String SO_SI_GROUP_MEM_PRPTY_ID_SEQ = "SO_SI_GROUP_MEM_PRPTY_ID";// ��������ʵ�����Ա���Ա��

	public static final String SO_RES_ID_SEQ = "SO_RES_ID";// ������Դʵ�����

	public static final String RES_NWKSEG_ID_SEQ = "RES_NWKSEG_ID";// ��Դ���α��

	public static final String XMLHEADER_SERIALNO_FOR_RMS_SEQ = "XMLHEADER_SERIALNO_FOR_RMS";// ��Դ�ӿڲ�������

	public static final String SO_NBR_SEQ = "SO_NBR";// ��������

	public static final String SO_IP_ADDR_ID_SEQ = "SO_IP_ADDR_ID";// IP��ַ��Ϣ���

	public static final String SO_USERNAME_ID_SEQ = "SO_USERNAME_ID";// �����ʻ�������

	public static final String USER_DATA_RANGE_ID_SEQ = "USER_RANGE_ID";// �û�����Ȩ�ޱ���

	public static final String REQ_DATE_SMS_ID_SEQ = "REQ_DATE_SMS_ID";// ԤԼ���������Ϣ����

	public static final String STEP_RES_SERV_ID_SEQ = "STEP_RES_SERV_ID";// ������Դ����

	public static final String PROD_RES_SERV_ID_SEQ = "PROD_RES_SERV_ID";// ��Ʒ��Դ����

	public static final String SO_HANDLE_ID_SEQ = "SO_HANDLE_ID";// ����������̱�ʶ

	public static final String SO_SI_GROUP_NO_SEQ = "SO_SI_GROUP_NO";// ��������ʵ������

	public static final String SO_AUTH_ID_SEQ = "SO_AUTH_ID";// ��֤��Ϣ���

	public static final String SO_TEL_GUIDE_ID_SEQ = "SO_TEL_GUIDE_ID";// �����绰������Ϣ���

	public static final String SO_PVC_ID_SEQ = "SO_PVC_ID";// ��������PVC��·��Ϣ

	public static final String SO_CIRCUIT_ID_SEQ = "SO_CIRCUIT_ID";// ��·��Ϣ���

	public static final String STEP_CONFIG_ID_SEQ = "STEP_CONFIG_ID"; // �������ñ��

	public static final String STEP_CANCEL_RULE_ID_SEQ = "STEP_CANCEL_RULE_ID"; // ���Ĺ������

	public static final String WORK_TYPE_TAB_NAME_ID_SEQ = "WORK_TYPE_TAB_NAME_ID";// �ɵ���ʽ

	public static final String NOTIFY_TYPE_ID_SEQ = "NOTIFY_TYPE_ID";// ֪ͨ����ID

	public static final String MSG_SEND_RULE_ID_SEQ = "MSG_SEND_RULE_ID";// ��Ϣ���Ͳ���

	public static final String REAL_TIME_BUSI_CONFIG_ID_SEQ = "REAL_TIME_BUSI_CONFIG_ID";// ����ʵʱ����

	public static final String SPEC_PRPTY_ID_SEQ = "SPEC_PRPTY_ID";

	public static final String BUSINESS_ID_SEQ = "BUSINESS_ID";

	public static final String CHG_SERV_SPEC_ID_SEQ = "CHG_SERV_SPEC_ID";

	public static final String PRPTY_PARA_ID_SEQ = "PRPTY_PARA_ID";// ��������ȡֵ����

	public static final String PARA_VALUE_MAP_ID_SEQ = "PARA_VALUE_MAP_ID";// ��������ֵ��ӳ��

	public static final String ORDER_PARA_ID_SEQ = "ORDER_PARA_ID";// ����������

	public static final String PROD_ACTION_STEP_ID_SEQ = "PROD_ACTION_STEP_ID";// ����������

	public static final String WF_EXPRESS_ID_SEQ = "WF_EXPRESS_ID";// �������ʽ

	public static final String WF_PARAMETER_ID_SEQ = "WF_PARAMETER_ID";// ��������

	public static final String WORK_AREA_OBJ_ID_SEQ = "WORK_AREA_OBJ_ID";// �Ǿ���������

	public static final String MSG_TEMPLATE_ID_SEQ = "MSG_TEMPLATE_ID";// ��Ϣģ������

	public static final String SO_ATTACH_ID_SEQ = "SO_ATTACH_ID"; // ��������

	public static final String WO_DESIGN_ID_SEQ = "WO_DESIGN_ID"; // ʩ�����

	public static final String WO_DESIGN_DETAIL_ID_SEQ = "WO_DESIGN_DETAIL_ID"; // ʩ�������ϸ��Ϣ

	public static final String STEP_DESIGN_MATCH_ID_SEQ = "STEP_DESIGN_MATCH_ID";// �������ƥ��Ҫ��

	public static final String STEP_DESIGN_ID_SEQ = "STEP_DESIGN_ID";// �������
	
	public static final String WO_FACTOR_INST_ID_SEQ = "WO_FACTOR_INST_ID";
	
	public static final String WO_ITEM_ID_SEQ = "WO_ITEM_ID";// WO_ITEM.WO_ITEM_ID
	
	public static final String WF_PROC_NODE_ACTIVITY_SEQ = "WF_PROC_NODE_ACTIVITY_ID";

	public static final String PARSE_CONFIG_ID_SEQ = "PARSE_CONFIG_ID";//�����������ݱ���
	public static final String WORK_REPORT_ID_SEQ = "WORK_REPORT_ID";//Ѳ�챨��
	
	public static final String SO_TEST_RESULT_ID_SEQ = "SO_TEST_RESULT_ID";//�ϰ����Խ��
	
	public static final String SO_TEST_RESULT_ITEM_ID_SEQ = "SO_TEST_RESULT_ITEM_ID";//�ϰ����Խ������Ϣ
	
	/** ��Ʒ�����Ʒ��ϵ�����к� */
	public static final String TRADE_PROD_ID_SEQ = "TRADE_PROD_ID";// ��Ʒ�����Ʒ��ϵ��ID��
	public static final String TRADE_ID_SEQ = "TRADE_ID";

	/** PM CRM���ɹ����� */
	public static final String PROD_TREE_ID_SEQ = "PROD_TREE_ID";// ��Ʒ�ṩ��

	public static final String WO_GROUP_ID_SEQ = "WO_GROUP_ID";// �������ʶ

	public static final String WO_GROUP_MEMBER_ID_SEQ = "WO_GROUP_MEMBER_ID";// �������Ա��ʶ

	public static final String SSO_TEMP_SESSION_ID_SEQ = "SSO_TEMP_SESSION_ID";// �����½

	public static final String RES_XML_MSG_ID_SEQ = "RES_XML_MSG_ID";
	
	public static final String SO_SLA_ID_SEQ = "SO_SLA_ID";//  
	
	public static final String SO_PWC_ID_SEQ = "SO_PWC_ID";//  ר�ߵ�·
	
	public static final String SO_PWC_PRPTY_ID_SEQ = "SO_PWC_PRPTY_ID";//  ר�ߵ�·����
	
	public static final String MAINT_WORK_AREA_ID_SEQ = "MAINT_WORK_AREA_ID";//ά�����͹�����ϵ��ʶ
	

	/** *************************����������******************************** */
	public static final String WF_ACTIVITY_SEQ = "ACTIVITY_ID"; // �SEQ�����������õģ�

	/** ************************���/KPI���� add at 08.04.02 by huangyx************ */
	public static final String CHECK_RULE_ID_SEQ = "CHECK_RULE_ID"; // ��ع���

	public static final String SERVER_APPLICATION_ID_SEQ = "SERVER_APPLICATION_ID"; // ��̨Ӧ��

	public static final String PROCESS_STATUS_ID_SEQ = "PROCESS_STATUS_ID"; // ����״̬

	public static final String THREAD_STATUS_ID_SEQ = "THREAD_STATUS_ID"; // �߳�״̬

	/** *******************�������ӿڲ���*********************************** */
	// �¼�
	public static final String PROC_START = "PROC_START";

	public static final String PROC_INST_START = "PROC_INST_START";

	public static final String PROC_PAUSE = "PROC_PAUSE";

	public static final String PROC_CANCEL = "PROC_CANCEL";

	public static final String PROC_CONTINUE = "PROC_CONTINUE";

	public static final String WORKITEM_SUCCESS = "WORKITEM_SUCCESS";

	public static final String WORKITEM_FAIL = "WORKITEM_FAIL";

	public static final String RELATION_CANCEL = "RELATION_CANCEL";
	// ���̹�ϵ����
	public static final String RELA_TYPE_FOR_MODIFY = "3";

	public static final String RELA_TYPE_FOR_REMOKE = "4";

	// �������ص��ӿڵ��÷���ֵ
	public static final String RET_CODE_DO_SUCCESSED = "0";// ����ɹ� ����������������̣�

	// ������
	public static final String RET_CODE_PROC_INEXIST = "1";// ���̲�����

	// ��������
	public static final String RET_CODE_STOP_CURRENT_STEP = "2";// ͣ����ǰ���ڣ��쳣��������Ϊ������ǰ���ڣ�

	public static final String RET_CODE_EXCEPTION_PROCE_INEXIST = "3";// ��ѯ�����쳣����

	public static final String RET_CODE_RETURN_START_SYSTEM = "4"; // ���ط���ϵͳ���쳣���̴�������Ϊ���˵�����ϵͳ��

	public static final String RET_CODE_REVERSE_WORKITEM_NOFAILED = "5";// ���������ʧ�ܻص�

	public static final String RET_CODE_REVERSE_EXEC_SUCCESSFUL = "6";// ��ǰ�������Ѿ��ɹ�ִ�У����ܹ��ٴλص���

	// Эͬ��ϵ����

	public static final String COLLAB_TYPE_C_S = "C->S";// ����������ʼ

	public static final String COLLAB_TYPE_S_S = "S->S";// ��ʼ������ʼ

	public static final String COLLAB_TYPE_C_C = "C->C";// ������������

	public static final String COLLAB_TYPE_SSCC = "SSCC";// ͬʱ��ʼ��ͬʱ����

	public static final String COLLAB_TYPE_SS = "SS";// ͬʱ��ʼ

	// ʵʱ��־
	public static final String REAL_TIME = "Y";// ʵʱ

	public static final String UN_REAL_TIME = "N";// ��ʵʱ

	public static final String WF_REALTIME_TRUE = "1"; // ʵʱ

	public static final String WF_REALTIME_FALSE = "0"; // ��ʵʱ
	
	public static final String WF_REAL_TIME_FLAG = "WF_REAL_TIME_FLAG";

	// ��ѯ������ҳ��������
	public static final String ROWS_PER_PAGE = "20";

	// ����ͨ���ع���������˵��
	public static final String DISPATCH_RESULT_KEY = "DISPATCH_RESULT";// �������ɷ����ؽ���ļ�ֵ

	public static final String EXEC_SUCCESS = "EXECUTE_OK"; // ִ�гɹ�

	public static final String DISPATCH_SUCCESS = "DISPATCH_OK"; // �ɷ��ɹ�

	public static final String TOTE_OBJECT = "TOTE_OBJECT";// ҵ��ϵͳ��Ҫ������Я������ļ�ֵ

	// �������÷���ͨ������˵��

	public static final String INTERFACE_CONFIG_WORKITEM_XML_KEY = "WORKITEM_XML";

	public static final String INTERFACE_CONFIG_WORKITEM_ID_KEY = "WORKITEM_ID";

	public static final String INTERFACE_CONFIG_SO_NBR_KEY = "SO_NBR"; //

	public static final String INTERFACE_CONFIG_EXT_SO_NBR_KEY = "EXT_SO_NBR";

	public static final String INTERFACE_CONFIG_LOCK_STATE_KEY = "LOCK_STATE";

	public static final String INTERFACE_CONFIG_SO_SEQ_KEY = "SO_SEQ";

	public static final String INTERFACE_CONFIG_PROC_LIMIT_DATE_KEY = "PROC_LIMIT_DATE"; // ���̸澯ʱ��

	public static final String INTERFACE_CONFIG_PROC_PRE_LIMIT_DATE_KEY = "PROC_PRE_LIMIT_DATE"; // ����Ԥ��ʱ��

	public static final String INTERFACE_CONFIG_PROC_INST_ID_KEY = "PROC_INST_ID";

	public static final String INTERFACE_CONFIG_WO_NBR_KEY = "WO_NBR";

	public static final String INTERFACE_CONFIG_PROC_NODE_ID_KEY = "PROC_NODE_ID";

	public static final String INTERFACE_CONFIG_STAFF_ID_KEY = "STAFF_ID";

	public static final String INTERFACE_CONFIG_WO_RUN_STS_KEY = "RUN_STS";

	public static final String INTERFACE_CONFIG_METHOD_NAME_KEY = "METHOD_NAME";

	public static final String INTERFACE_CONFIG_WO_WO_STAFF_ID_KEY = "WO_STAFF_ID";

	public static final String INTERFACE_CONFIG_WO_RT_STAFF_ID_KEY = "RT_STAFF_ID";

	public static final String INTERFACE_CONFIG_WO_REMARKS_KEY = "REMARKS";
	
	public static final String INTERFACE_CONFIG_STEP_ID = "STEP_ID";
	
	public static final String INTERFACE_CONFIG_STEP_DESC = "STEP_DESC";
	
	public static final String INTERFACE_CONFIG_STEP_LIST = "STEP_LIST";
	
	public static final String INTERFACE_CONFIG_REFACTOR_NODE_INST_ID = "REFACTOR_NODE_INST_ID";
	
	public static final String INTERFACE_CONFIG_REFACTOR_NODE_INST_DESC = "REFACTOR_NODE_INST_DESC";
	
	public static final String INTERFACE_CONFIG_WO_RUN_STS = "WO_RUN_STS";

	/*----------------------------------�ӿڵ��÷�����---------------------------------------------*/

	public static final String INTERFACE_CONFIG_METHOD_WO_RESEND = "woResend";

	public static final String INTERFACE_CONFIG_METHOD_QUERY_WO_IN_PREFORM = "queryWoInPerform";

	public static final String INTERFACE_CONFIG_METHOD_WO_BACK = "woBack";

	public static final String INTERFACE_CONFIG_METHOD_WO_REVERSE = "woReverse";

	public static final String INTERFACE_CONFIG_METHOD_HAS_COLLAB_WO = "hasCollabWo";

	// ����Ӌ��r��
	public static final String LIMIT_DATE = "LIMIT_DATE";// �澯ʱ��

	public static final String PRE_LIMIT_DATE = "PRE_LIMIT_DATE";// Ԥ��ʱ��

	// ״̬ͬ������˵����
	public static final String SYNC_STS_PS_RUNNING = "PS_RUNNING"; // ������������

	public static final String SYNC_STS_PS_FINISH = "PS_FINISH"; // �������н���

	public static final String SYNC_STS_PS_WAIT = "PS_WAIT"; // ����ͬ���ȴ�״̬

	public static final String SYNC_STS_NS_WAIT = "NS_WAIT"; // ����ͬ���ȴ�״̬

	public static final String SYNC_STS_PS_CONTINUE = "PS_CONTINUE"; // ȡ��ͬ���ȴ��ӿ�

	//
	public static final String SYNC_TYPE_KEY = "SYNC_TYPE"; // ��ֵ

	/** *******************CRM�ӿڲ���*********************************** */
	public static final String AUTHOR_VALUE = "Y";

	// �¾ɱ�־ NO_FLAG
	public static final String NO_FLAG_NEW = "A";// A ��

	public static final String NO_FLAG_OLD = "P";// P ��

	public static final String NO_FLAG_NEW_AND_OLD = "AP";// AP �¾ɣ��ġ���

	// �ͻ���Դ CUST_SOURCE
	public static final String CUST_SOURCE_BY_SELF = "A";// A ���ҷ�չ

	public static final String CUST_SOURCE_BY_RIVAL = "B";// B ��������

	// ��������ȷ�ϱ�־ CONFIG_FLAG
	public static final String CONFIG_FLAG_YES = "0";// 0:û��ȷ��

	public static final String CONFIG_FLAG_NO = "1";// 1:�Ѿ�ȷ��

	// ԤԼ������� BOOK_COUNT
	public static final String BOOK_COUNT_DEFAULT = "0";

	public static final String BOOK_POINT_FOR_FRONT = "F";// ǰ̨ԤԼ

	public static final String BOOK_POINT_FOR_BACKGROUND = "B";// ��̨ԤԼ

	public static final String DEST_NBR = "34009";

	public static final String BOOK_STEP_ID = "34002";

	public static final String MSG_TYPE_FOR_NEW_BOOK = "0";

	public static final String MSG_TYPE_FOR_CANCLE_BOOK = "1";

	public static final String MSG_TYPE_FOR_CANCLE_SO = "2";

	public static final String MSG_TYPE_FOR_CHANGE_BOOK = "3";

	// �ͻ�������CUST_ORDER��״̬ STS
	public static final String CUST_ORDER_STS_NEW = "A";// A �½�

	public static final String CUST_ORDER_STS_ACC_ING = "B";// B ������

	public static final String CUST_ORDER_STS_ACC_ED = "C";// C ������

	public static final String CUST_ORDER_STS_DISUSE = "D";// D ����

	public static final String CUST_ORDER_STS_FINISH = "E";// E �ѿ���

	public static final String CUST_ORDER_STS_SEPARATE = "R";// R ���

	// �ͻ���������񶨵���ϵ��CUST_ORDER_BUSINESS��
	public static final String CUST_ORDER_BUSINESS_USE = "A";// ����

	public static final String CUST_ORDER_BUSINESS_UNUSE = "D";// ����

	public static final String CUST_ORDER_BUSINESS_SEPARATE = "R";// ���

	// ��������״̬��inter_serviece_ORDER ״̬ ��
	public static final String STS_ACCEPT_SUCCESS = "A";// �������ճɹ�

	public static final String STS_ANALYSIS_LOCK = "B";// ������������

	public static final String STS_AFREASH_LOCK = "F";// ������������

	public static final String STS_ANALYSIS_SUCCESS = "C";// ���������ɹ�

	public static final String STS_ANALYSIS_FAIL = "D";// ��������ʧ��

	public static final String STS_RETURN_ERROR_SUCCESS = "Z";// ���ݴ��󷵻�CRM�ɹ�

	public static final String STS_RETURN_ERROR_FAILED = "Y";// ���ݴ��󷵻�CRMʧ��

	public static final String STS_MATCH_FAILED = "E";// E����ƥ��ʧ��

	public static final String STS_PROCCESSING = "P";// P������������

	public static final String STS_PROC_FINISH_NOTIFY_SUCCESS = "H";// ��������֪ͨCRM�ɹ�

	public static final String STS_PROC_FINISH_NOTIFY_FAIL = "I";// ��������֪ͨCRMʧ��

	public static final String STS_CANCEL_SO_NOTITY_SUCCESS = "J";// �������֪ͨCRM�ɹ�

	public static final String STS_CANCEL_SO_NOTITY_FAIL = "K";// �������֪ͨCRMʧ��

	public static final String STS_RETURN_SO_NOTITY_SUCCESS = "L";// ʩ��ʧ���˻�CRM�ɹ�

	public static final String STS_RETURN_SO_NOTITY_FAIL = "M";// ʩ��ʧ���˻�CRMʧ��

	// �ͻ�������ϸ�������� ITEM_TYPE
	public static final String ITEM_TYPE_PROD_NEW = "A";// A ��Ʒ�¹�

	public static final String ITEM_TYPE_SERV_CHANGE = "B";// B ������

	// ���ұ�־
	public static final String IS_SELF_YES = "Y";// Y ��

	public static final String IS_SELF_NO = "N";// N �񣬹�����

	// �˹�ʩ��������
	public static final String MAN_WORK_TYPE_ID = "6";// Y ��

	// isSelf 0:����ʵ�� 1:ʵ������ 2:��ǰ��Ʒʵ��
	public static final String IS_SELF_REL = "0";

	public static final String IS_SELF_SEL = "1";

	public static final String IS_SELF_BEF = "2";

	// �����־ Y �б�� N δ���
	public static final String CHANGED_FLAG_YES = "Y";

	public static final String CHANGED_FLAG_NO = "N";

	// �����־ Y �б�� N δ���
	public static final String TWO_EXCH_FLAG_YES = "Y";

	public static final String TWO_EXCH_FLAG_NO = "N";

	// ������־ IS_MAIN Y ����Ʒ N ������Ʒ
	public static final String IS_MAIN_YES = "Y";

	public static final String IS_MAIN_NO = "N";

	// ��������״̬
	public static final String SO_ANALYSIS_SECCESS = "C";

	public static final String SO_ANALYSIS_FAIL = "D";

	// ��������
	public static final String RELATED_TYPE_FUTILITY = "1";// ע����

	public static final String RELATED_TYPE_MODIFY = "2";// �޸ĵ�

	public static final String RELATED_TYPE_NORMOY = "0";// ������

	public static final String RELATED_TYPE_FOR_WAIT = "3";// ��װ��

	public static final String RELATED_TYPE_FOR_AGAIN = "4";// ��װ��

	// �������ظ�CRM���״̬
	public static final String RESULT_CODE_SUCCESS = "0";// �ɹ�

	public static final String RESULT_CODE_FAIL = "1";// ʧ��

	// �������ĵ����
	public static final String AUDIT_PASS = "0";// �ɹ�

	public static final String AUDIT_UN_PASS = "1";// ʧ��

	public static final String AUDIT_PASS_FINISH = "2"; // ���ĵ����

	// �ش�CRM������������

	public static final String SO_RETURN_TYPE_FINISH = "C";// ��������

	public static final String SO_RETURN_TYPE_BACK = "T";// �˵�����

	public static final String SO_RETURN_TYPE_FAIL = "F";// ����ʧ�ܷ���

	public static final String SO_RETURN_TYPE_REMOVE = "E";// ������ɷ���

	// ��������
	public static final String EXPT_TYPE_SO_MODIFY = "2";// �޸ĵ�

	public static final String EXPT_TYPE_FUTILITY = "1";// ע����

	public static final String EXPT_TYPE_RE_RECEIVE = "6";// �ط���

	public static final String EXPT_TYPE_RELE_RES = "7";// ��Դ�ͷ�

	// �����Ƿ񵽴� SO_PARSE_FLAG
	public static final String SO_PARSE_FLAG_YES = "Y";// �����Ѿ�����SPS

	public static final String SO_PARSE_FLAG_NO = "N";// ������δ��SPS

	public static final String SO_SI_GROUP_OLD = "OLD";// ��������ʵ����

	public static final String SO_SI_GROUP_NEW = "NEW";// ��������ʵ����

	// �Ƿ�ȡ��ԤԼ��־
	public static final String CANCLE_BOOK_YES = "Y"; //

	public static final String CANCLE_BOOK_NO = "N";

	// �Ƿ��ͷ���Դ��־
	public static final String UNCHAIN_SO_SI_GROUP_YES = "Y";

	public static final String UNCHAIN_SO_SI_GROUP_NO = "N";

	public static final String SO_SI_GROUP_ACT_TYPE_MODIFY = "M";

	public static final String SO_SI_GROUP_ACT_TYPE_NEW = "A";

	public static final String SO_SI_GROUP_ACT_TYPE_DEL = "R";

	public static final String ACT_TYPE_FROM_CRM_HIS = "P";

	// ������������
	public static final String SO_CHANGE_FOR_SO_ADDR = "SO_ADDR";// ������ַ��Ϣ��
	
	public static final String SO_CHANGE_FOR_SO_IP_ADDR = "SO_IP_ADDR";// ����IP��ַ��Ϣ��

	public static final String SO_CHANGE_FOR_SO_ACC_NBR = "SO_ACC_NBR";// ����������Ϣ��

	public static final String SO_CHANGE_FOR_SO_PVC = "SO_PVC";// ����SO_PVC��Ϣ��

	public static final String SO_CHANGE_FOR_SO_CIRCUIT = "SO_CIRCUIT";// ������·��Ϣ��

	public static final String SO_CHANGE_FOR_SO_MAIN_PROD_PRPTY = "SO_MAIN_PROD_PRPTY";// ��������Ʒ������Ϣ��

	public static final String SO_CHANGE_FOR_SO_SUB_PROD_PRPTY = "SO_SUB_PROD_PRPTY";// ����������Ʒ������Ϣ��

	public static final String SO_CHANGE_FOR_SO_EQPT_PRPTY = "SO_EQPT_PRPTY";// �豸������Ϣ��
	
	public static final String SO_CHANGE_FOR_SO_PWC_PRPTY = "SO_PWC_PRPTY";// pwcר�ߵ�·������Ϣ
	
	public static final String SO_CHANGE_FOR_SO_BOOK = "SO_BOOK";// ����ԤԼ��Ϣ

	// ����������Ҫ���⴦��Ĳ�Ʒ���뻧����
	public static final String PROD_ID_FOR_TEL = "10000000";// ��ͨ�绰

	public static final String PROD_ID_FOR_ADSL = "20001001";// ADSL���Ⲧ��

	public static final String PROD_ID_FOR_PHS = "15000000";// �����л�

	public static final String GROUP_SPEC_ID_FOR_SHARE_LINE = "2";// ����Ⱥ��

	public static final String CHG_SERV_SPEC_ID_FOR_MOVE = "3007";// �ƻ�

	public static final String CHG_SERV_SPEC_ID_FOR_CHANGE_ACC_NBR = "3006";// �ĺ�

	public static final String CHG_SERV_SPEC_ID_FOR_CHANGE_ACC_NBR_AND_ADD_SUB = "3053";// �ĺż�������������
	
	// �ӿڱ�ʶfuncode

	public static final String FUNCODE_RECEIVE_SO = "receiveSo"; // ���ն�������
	
	public static final String FUNCODE_IS_ALLOW_CANCEL_SO = "isAllowCancelSo"; // ����ѯ�ʽӿ�
	
	public static final String FUNCODE_IS_ALLOW_CHANGE_SO = "isAllowChangeSo"; // �ĵ�ѯ�ʽӿ�
	
	public static final String FUNCODE_UN_LOCK_SO = "unLockSo"; // ���������ӿ�
	
	public static final String FUNCODE_RECEIVE_ROLL_SO = "receiveRollSo"; // ��������ӿ�
	
	public static final String FUNCODE_RE_RECEIVE_SO = "reReceiveSo"; // �������ӿ�
	
	public static final String FUNCODE_CHANGE_SO_BOOK = "changeSoBook"; // ԤԼ�޸Ľӿ�
	
	public static final String FUNCODE_RECEIVE_CANCEL_SO_NOTIFY = "receiveCancelSoNotify"; // �������֪ͨ�ӿ�
	
	public static final String FUNCODE_SO_COMPLETE = "soComplete"; // ���������ӿ�
	
	public static final String FUNCODE_SO_EXPT_BACK = "soExptBack"; // �������򿢹��ӿ�
	
	public static final String FUNCODE_SO_SEND_BACK = "soSendBack"; // �����˻�Ӫҵ�ӿ�
	
	public static final String FUNCODE_COML_PAY_NOTIFY = "complPayNotify"; // CRM�շ�֪ͨ�ӿ�
	
	public static final String FUNCODE_IS_PAY_CHARGE = "isPayCharge"; // IOM�շѲ�ѯ�ӿ�
	
	public static final String FUNCODE_CONNECT_TEST = "connectTest"; // �ӿ���ͨ�Բ��Խӿ�
	
	public static final String FUNCODE_CHG_PASSWORD = "chgPass";// ͬ������ӿ�
	
	public static final String FUNCODE_WORK_ORDER_RETURN = "workOrderReturn";// ʩ�����Ȼص��ӿ�
	
	public static final String FUNCODE_INCEPT_WO = "inceptWO";// �ɵ��ӿ�
	
	public static final String SCHEMA_FOR_SERVICE_ORDER = "ServiceOrder.xsd"; // ���񶨵��ӿ�Э��
	
	public static final String SCHEMA_FOR_SERVICE_ORDERS = "ServiceOrders.xsd"; // �������񶨵��ӿ�Э��
	
	public static final String SCHEMA_FOR_EXPT_SERVICE_ORDER = "ExptServiceOrder.xsd"; // �쳣������񶨵��ӿ�Э��
	
	public static final String SCHEMA_FOR_SERVICE_ORDER_RETURN = "ServiceOrderReturn.xsd"; // ���񶨵�����CRM�ӿ�Э��
	
	public static final String SCHEMA_CATALOG = "schema\\"; // schemaЭ����Ŀ¼
	
	/** *********************************��Դ�ӿ�***************************************** */
	// �ӿڱ���(_EID)
	public static final String EID_RES_SO_SYNC_SERV_REQ = "RES_SO_SYNC_SERV_REQ";// ����ͬ������

	public static final String EID_RES_SO_SYNC_SERV_RESP = "RES_SO_SYNC_SERV_RESP";// ����ͬ������

	public static final String EID_RES_DSGN_SERV_REQ = "RES_DSGN_SERV_REQ";// ��Դ���÷����������

	public static final String EID_RES_DSGN_SERV_RESP = "RES_DSGN_SERV_RESP";// ��Դ���÷�����Ʒ���

	public static final String EID_RES_QRY_SERV_REQ = "RES_QRY_SERV_REQ";// ��ѯ��Դ��������

	public static final String EID_RES_ASGN_SERV_REQ = "RES_ASGN_SERV_REQ";// ������Դ��������
	
	public static final String EID_RES_ASGN_SSMODULE_REQ = "RES_ASGN_SSMODULE_REQ";//����ģ�����
	
	public static final String EID_RES_ASGN_SSMODULE_RESP = "RES_ASGN_SSMODULE_RESP";//����ģ����䷵��

	public static final String EID_RES_CNL_SERV_REQ = "RES_CNL_SERV_REQ";// ������Դ��������

	public static final String EID_RES_SO_REVERSE_REQ = "RES_SO_REVERSE_REQ";// ������������

	public static final String EID_RES_ASGN_SERV_RESP = "RES_ASGN_SERV_RESP";// ������Դ���񷵻�

	public static final String EID_RES_ARC_SERV_REQ = "RES_ARC_SERV_REQ";// �鵵��������

	public static final String EID_RES_ARC_SERV_RESP = "RES_ARC_SERV_RESP";// �鵵���񷵻�

	public static final String EID_RES_CHECK_REQ = "RES_CHECK_REQ";// ��Դ�ʼ�����

	public static final String EID_RES_CHECK_RESP = "RES_CHECK_RESP";// ��Դ�ʼ췵��
	
	public static final String EID_RES_PRE_CHECK_REQ = "RES_PRE_CHECK_REQ";// ��ԴԤ������
	
	public static final String EID_RES_PRE_CANCEL_CHECK_REQ = "EID_RES_PRE_CANCEL_CHECK_REQ";// ��ԴԤ�������� add by �ֺ�� 20110311

	public static final String EID_RES_PRE_CHECK_RESP = "RES_PRE_CHECK_RESP";// ��ԴԤ�з���

	public static final String EID_RES_REPL_SERV_RESP = "RES_REPL_SERV_RESP";// ��Դ�󲹷���

	public static final String EID_RES_CTO_SO_REQ = "RES_CTO_SO_RESP";// ��Դ�޵�����

	public static final String EID_RES_CTO_SO_RESP = "RES_CTO_SO_RESP";// �޵�����

	public static final String EID_RES_WAIT_REQ = "RES_WAIT_REQ";// ��װ�ص�����

	public static final String EID_RES_WAIT_RESP = "RES_WAIT_RESP";// ��װ�ص�
	
	public static final String EID_RES_SO_ADDR_QUERY = "RES_SO_ADDR_QUERY"; // ���ݱ�׼��ַ��ѯ������Ϣ
	
	public static final String EID_USED_RES_CHANGE = "USED_RES_CHANGE"; //�����û���Դ������������ã�

	public static final String EID_USED_RES_QUERY = "SAS_QRY_SERV_REQ";//�����û���Դ��ѯ����������
	

	

	// �ӿڱ�ʶfuncode

	public static final String FUNCODE_SO_SYNC_REQUEST = "soSyncRequest"; // ���񶨵�ͬ������

	public static final String FUNCODE_SO_SYNC_RESPONSE = "soSyncResponse"; // ���񶨵�ͬ������

	public static final String FUNCODE_RES_QUERY_REQUEST = "resQueryRequest"; // ��Դ�����ѯ����

	public static final String FUNCODE_RES_ASSIGN_REQUEST = "resAssignRequest";// ��Դ������������

	public static final String FUNCODE_RES_ASSIGN_RESPONSE = "resAssignResponse"; // ��Դ�������÷���
	
	public static final String FUNCODE_RES_ASGNSSMODULE_REQUEST = "resAsgnSsModuleRequest";//����ģ���������

	public static final String FUNCODE_RES_ASSIGN_CANCEL_REQUEST = "resAssignCancelRequest";// ��Դ��������ȡ������

	public static final String FUNCODE_RES_SO_REVERSE_REQUEST = "soReverseRequest";// ������Դ����

	public static final String FUNCODE_RES_DISIGN_REQUEST = "resDesignRequest"; // ��Դ�����������

	public static final String FUNCODE_RES_DESIGN_RESPONSE = "resDesignResponse";// ��Դ������Ʒ���

	public static final String FUNCODE_RES_ARCHIVE_REQUEST = "resArchiveRequest"; // ��Դ�鵵����

	public static final String FUNCODE_RES_ARCHIVE_RESPONSE = "resArchiveResponse";// ��Դ�鵵����

	public static final String FUNCODE_RES_CHECK_REQUEST = "resCheckRequest";// ��Դ�ʼ�����

	public static final String FUNCODE_RES_CHECK_RESPONSE = "resCheckResponse"; // ��Դ�ʼ췴��

	public static final String FUNCODE_RES_PRE_CHECK_REQUEST = "resPreCheckRequest";// ��ԴԤ������
	
	public static final String FUNCODE_RES_CANCEL_PRE_CHECK_REQUEST = "resCanclePreCheckRequest";// ��ԴԤ�з������� add by �ֺ�� 20110311

	public static final String FUNCODE_RES_PRE_CHECK_RESPONSE = "resPreCheckResponse"; // ��Դ�ʼ췴��

	public static final String FUNCODE_RES_CTO_SO_REQUEST = "resCtoSoRequest";// ��Դ�޵�����
	
	public static final String FUNCODE_NAS_FEEDBACK = "nasFeedBack";//�����Զ�ʩ��������� add by �ֺ�� 20110826
	
	public static final String FUNCODE_NAS_QUERY_FAILREASON = "queryFailReason";//�����ѯ�����쳣ԭ�� add by �ֺ�� 20110826

	public static final String FUNCODE_RES_CTO_SO_RESPONSE = "resCtoSoResponse"; // �޵��������

	public static final String FUNCODE_RES_WAIT_REQ = "resWaitRequest";// ��װ�ص�����

	public static final String FUNCODE_RES_WAIT_RESP = "resWaitResponse";// ��װ�ص�

	public static final String FUNCODE_RES_SO_ADDR_QRY_REQUEST = "soAddrQryRequest";// ���ݱ�׼��ַ��ѯά��������
	
	public static final String FUNCODE_RES_CHANGE_SAS_REQUEST = "usedResChange";	//�����û���Դ�������������
	
	public static final String FUNCODE_RES_QRY_SAS_REQUEST = "sasQueryRequest"; //�����û���Դ��ѯ����������

	public static final String FUNCODE_SAS_QRY_CRM_REQUEST = "sasQueryCRMRequest"; //�ͻ����ϲ�ѯ����������
	
	public static final String FUNCODE_RES_RETURN_WO_RESPONSE = "resReturnWoResponse";//���ʻص�
	
	// ��֤�û�
	public static final String RES_SECURITY_PRINCIPAL = "admin"; // �û�

	// ��֤����
	public static final String RES_SECURITY_CREDENTIALS = "qazwsxedc";// ����

	// ͨѶ��ʽ
	public static final String EVENT_TYPE_FOR_SYNC = "SYNC"; // ͬ��

	public static final String EVENT_TYPE_FOR_ASYN = "ASYN"; // �첽

	//
	public static final String APPLICATION_SYSTEM = "SPS"; // ����ͨϵͳ

	// ��Դ���ر���
	public static final String RES_RESULT_CODE_SUCCESS = "0"; // ���óɹ�

	public static final String RES_RESULT_CODE_FAIL = "-1"; // ���óɹ�

	// ʩ������ϵͳ���ر���
	public static final String WTS_RESULT_CODE_SUCCESS = "0"; // ���óɹ�

	public static final String WTS_RESULT_CODE_FAIL = "-1"; // ���óɹ�

	// ��������
	public static final String ACT_TYPE_ASSIGN = "A"; // ��Դ����

	public static final String ACT_TYPE_QUERY = "Q"; // ��Դ��ѯ

	public static final String ACT_TYPE_CANCEL = "C"; // ��Դ����

	public static final String ACT_TYPE_DESIGN = "D"; // ��Դ����

	// AZ��־ת��
	public static final String AZ_FLAG_TYPE_A = "1";// ��ӦAZ_FLAG ��A��

	public static final String AZ_FLAG_TYPE_Z = "2";// ��ӦAZ_FLAG��Z��

	// AZ_FLAGAZ�˱�־
	public static final String AZ_FLAG_A = "A";// A��

	public static final String AZ_FLAG_Z = "Z";// Z��

	// ����ͨ����Դ�������ڶ���

	public static final String STEP_ID_SO_SYNC = "SC0001";// ����ͬ��

	public static final String STEP_ID_QUERY_RES = "SC0002";// ��Դ��ѯ
	
	public static final String STEP_ID_QUERY_RES_SAS = "SC2009";//��Դ��ѯ(������)

	public static final String STEP_ID_RES_DESIGN = "SC0003";// �������

	public static final String STEP_ID_ASSIGN_LINE = "RA0001";// ����

	public static final String STEP_ID_ASSIGN_NUM = "RA0002";// ���

	public static final String STEP_ID_ASSIGN_PORT = "RA0003";// ��˿�

	public static final String STEP_ID_LINE_CHECK = "RA0004";// �����ʼ�

	public static final String STEP_ID_RES_ARCHIVE = "SC0004";// ��Դ�鵵

	public static final String STEP_ID_ASSIGN_IP = "RA0015";// ��IP

	public static final String STEP_ID_ASSIGN_LINE_NUM = "RA0020";// ��ר�ߺ�

	public static final String STEP_ID_ASSIGN_NUM_PORT = "RA0025";// �����ݶ˿�

	public static final String STEP_ID_ASSIGN_LINE_PORT = "RA0030";// ��LAN�˿�

	public static final String STEP_ID_ASSIGN_MACHINRY_NUM = "RA0035";// �������

	// ��ŷ�ʽ
	public static final String ASSIGN_NBR_TYPE_FOREGROUND = "0";// ǰ̨ѡ��
	public static final String ASSIGN_NBR_TYPE_FORBACKAUTOASSIGN = "1";// ��̨�Զ����

	// ��������

	public static final String ACC_NBR_PRPTY_DISTNBR = "1000006";// �߼���������

	public static final String ACC_NBR_PRPTY_ACCNBR = "1000001";// �߼�����

	public static final String ACC_NBR_PRPTY_PHYACCNBR = "1000000";// �������

	public static final String ACC_NBR_PRPTY_PHYDISTNBR = "1000007";// �����������

	public static final String ACC_NBR_PRPTY_MDFPORT = "2000001";// ���߼ܶ˿�

	public static final String ACC_NBR_PRPTY_MDFEPAIR = "3000026";// ���߼�1���ж���
	
	public static final String ACC_NBR_PRPTY_MDFEPAIR2 = "3000031";//	���߼�2���ж���

	public static final String ACC_NBR_PRPTY_MDFNAME = "3000025";// ���߼�1����
	
	public static final String ACC_NBR_PRPTY_MDFNAME2 = "3000030";// ���߼�2����

	public static final String ACC_NBR_PRPTY_MDFDPAIR = "3000027";// ���߼�1ֱ�ж���1
	
	public static final String ACC_NBR_PRPTY_MDFDPAIR2 = "3000028";//���߼�1ֱ�ж���2
	
	public static final String ACC_NBR_PRPTY_MDFDPAIR2_1 = "3000028";//���߼�2ֱ�ж���1

	public static final String ACC_NBR_PRPTY_MDFDPAIR2_2 = "3000028";//���߼�2ֱ�ж���2
	
	// MDF_E_I_PAIR
	public static final String ACC_NBR_PRPTY_MDF_E_I_PAIR = "2000014"; // ������˶���

	public static final String ACC_NBR_PRPTY_MDF_E_I_PAIR2 = "2000016"; // �����߼�2������˶���
	
	// MDF_E_O_PAIR
	public static final String ACC_NBR_PRPTY_MDF_E_O_PAIR = "2000015"; // ���г��˶���
	
	public static final String ACC_NBR_PRPTY_MDF_E_O_PAIR2 = "2000017"; // �����߼�2���г��˶���

	

	public static final String RES_PRPTY_IP_ADDR = "1000002";// IP��ַ

	public static final String RES_PRPTY_SUB_MASK = "1000020";// ��������

	public static final String RES_PRPTY_GATEWAY = "4000016";// ����

	public static final String SHARED_LINE_MAIN_PROD = "10000000";// ��������Ʒ

	public static final String ADSL_PROD_ID = "20001001";// adsl��Ʒid

	public static final String ADSL_CHG_SERV_ID = "3001";// adslװ�ͻ�����ID

	public static final String NUM_PORT_SERV_ID = "203";// �˿���Դ�������

	public static final String SYS_CONFIG_ASSIGN_WORK_AREA = "2000060";// ����id

	public static final String SYS_CONFIG_ASSIGN_MDF_WORK_AREA = "3000046";// ���߼�����id
	
	public static final String SYS_CONFIG_ASSIGN_MDF_ID = "3000045";// ���߼�id
	public static final String SYS_CONFIG_ASSIGN_EPON_WORK_AREA = "3000049";// EPON�����ɵ�����id


	// ��Դ����

	public static final String RES_PRPTY_ID_SEQ = "RES_PRPTY_ID";// ��Դ����id

	public static final String RES_PRPTY_VALUE_ID_SEQ = "RES_PRPTY_VALUE_ID";// ��Դ����ֵid

	public static final String RES_PRPTY_TO_TYPE_ID_SEQ = "RES_PRPTY_TO_TYPE_ID";// ��Դ��������Դ���Թ�ϵid

	public static final String RES_PRPTY_TO_SERV_ID_SEQ = "RES_PRPTY_TO_SERV_ID";// ��Դ��������Դ���Թ�ϵid

	// �쳣ԭ�����
	public static final String FAIL_REASON_RES_SYS_ERROR = "20000180";// ��Դϵͳ�쳣

	public static final String FAIL_REASON_SPS_SYS_ERROR = "20000195";// ����ͨϵͳ�쳣

	public static final String FAIL_REASON_WTS_SYS_ERROR = "20000200"; // ʩ������ϵͳ�쳣

	/** *********************SQL��ѯ״̬����*************************************** */

	public static final String STATUS_HIS = "_HIS";// ��ѯ��ʷ��

	public static final String STATUS_ARC = "_ARC";// ��ѯ�鵵��

	/** ***********************��������id************************************************** */
	
	public static final String HANDLE_TYPE_CUSTOM_VISIT="509164"; //�ͻ��ط�
	
	public static final String HANDLE_TYPE_WO_BUILD = "400000";// ��������400000

	public static final String HANDLE_TYPE_WO_FETCH = "400010";// �˹��쵥

	public static final String HANDLE_TYPE_WO_AUTO_DISPATCH = "400020";// �����ɷ�

	public static final String HANDLE_TYPE_WO_PRINT = "400030";// ������ӡ

	public static final String HANDLE_TYPE_WO_SUCCESS_RET = "400040";// �ɹ��ص�

	public static final String HANDLE_TYPE_WO_FAIL_RET = "400050";// ʧ�ܻص�

	public static final String HANDLE_TYPE_WO_RESEND = "400060";// �����ɷ�

	public static final String HANDLE_TYPE_WO_SENDTO = "400070";// ����ת��

	public static final String HANDLE_TYPE_WO_AUDIT = "400080";// ��˴���
	
	public static final String HANDLE_TYPE_WO_WAITRETURN = "500190";//�ȴ��ص� add by �� 2011-817

	// public static final String HANDLE_TYPE_WO_RERET = "400090";// ���»ص�

	public static final String HANDLE_TYPE_WO_CHG_WORK_MODE = "400100";// ʩ����ʽ���

	public static final String HANDLE_TYPE_WO_SKIP = "400110";// �հ׹�������

	public static final String HANDLE_TYPE_WO_EXCEPTION_RESEND = "400120";// �쳣�ط�

	public static final String HANDLE_TYPE_WO_UNABLE = "400130";// ��������

	public static final String HANDLE_TYPE_WO_CC = "400150"; // ��������

	public static final String HANDLE_TYPE_WO_MODIFY = "400131";// �����޸�

	public static final String HANDLE_TYPE_WO_DESIGN = "400160";// ʩ����ƽ��

	// SO_HANDLE��ص�HANDLE_TYPE
	public static final String HANDLE_TYPE_SO_RETURN = "400170";

	public static final String HANDLE_TYPE_SO_RETURN_INFO = "�˻�ԭ��";
	public static final String HANDLE_TYPE_SO_PASS = "400180";

	public static final String HANDLE_TYPE_SO_PASS_INFO = "���ͨ��";
	public static final String HANDLE_TYPE_SO_WAIT = "400160";

	public static final String HANDLE_TYPE_SO_WAIT_INFO = "�ȴ����";
	public static final String HANDLE_TYPE_SO_BASE_MOD = "400190";
	public static final String HANDLE_TYPE_SO_BASE_MOD_INFO = "�����޸�";
	public static final String HANDLE_TYPE_SO_BASE_ADD = "400150";
	public static final String HANDLE_TYPE_SO_BASE_ADD_INFO = "����¼��";
	
	public static final String HANDLE_TYPE_SO_PRIORITY_ADJUST = "220280";
	public static final String HANDLE_TYPE_SO_PRIORITY_ADJUST_INFO = "�������ȼ�����";
	
	public static final String HANDLE_TYPE_SO_MANAGE = "220281";
	public static final String HANDLE_TYPE_SO_MANAGE_INFO = "��������";

	public static final String HANDLE_TYPE_SO_PARSE = "500000";// ��������

	public static final String HANDLE_TYPE_SO_PARSE_INFO = "��������";//

	public static final String HANDLE_TYPE_SO_MATCH = "500010";// ����ƥ��

	public static final String HANDLE_TYPE_SO_MATCH_INFO = "����ƥ��";

	public static final String HANDLE_TYPE_SO_START_PROC = "500020";// ������������

	public static final String HANDLE_TYPE_SO_START_PROC_INFO = "������������";//

	public static final String HANDLE_TYPE_SO_CHOOSE_PROC = "500030";// ����ѡ������

	public static final String HANDLE_TYPE_SO_CHOOSE_PROC_INFO = "����ѡ������";

	public static final String HANDLE_TYPE_SO_COLLAB_WAIT = "500040";// ����Эͬ�ȴ�

	public static final String HANDLE_TYPE_SO_COLLAB_WAIT_INFO = "����Эͬ�ȴ�";

	public static final String HANDLE_TYPE_SO_PROC_FINISH = "500050";// ����ʩ�����

	public static final String HANDLE_TYPE_SO_PROC_FINISH_INFO = "����ʩ�����";

	public static final String HANDLE_TYPE_SO_RES_ASSIGN = "500060";// ������Դ���÷��ظ�������

	public static final String HANDLE_TYPE_SO_RES_ASSIGN_INFO = "������Դ���÷��ظ�������";

	public static final String HANDLE_TYPE_SO_RETURN_CRM = "500070";// �����˻�Ӫҵ

	public static final String HANDLE_TYPE_SO_RETURN_CRM_INFO = "�����˻�Ӫҵ";

	public static final String HANDLE_TYPE_SO_PROD_RETURN = "500080";// ��Ʒ���Ի���

	public static final String HANDLE_TYPE_SO_PROD_RETURN_INFO = "��Ʒ���Ի���";

	public static final String HANDLE_TYPE_SO_LOCK = "500090";// ��������

	public static final String HANDLE_TYPE_SO_LOCK_INFO = "��������";

	public static final String HANDLE_TYPE_SO_UNLOCK = "500100";// ��������

	public static final String HANDLE_TYPE_SO_UNLOCK_INFO = "��������";

	public static final String HANDLE_TYPE_SO_REVERSE = "500110";// ���շ��򶨵�

	public static final String HANDLE_TYPE_SO_REVERSE_INFO = "���շ��򶨵�";

	public static final String HANDLE_TYPE_SO_REVERSE_FINISH = "500120";// �����������

	public static final String HANDLE_TYPE_SO_REVERSE_FINISH_INFO = "�����������";

	public static final String HANDLE_TYPE_SO_PAY_FINISH = "500130";// �����շ����

	public static final String HANDLE_TYPE_SO_PAY_FINISH_INFO = "�����շ����";

	public static final String HANDLE_TYPE_SO_REDO_NOTIFY = "500140";// ��������֪ͨ

	public static final String HANDLE_TYPE_SO_REDO_NOTIFY_INFO = "��������֪ͨ";

	public static final String HANDLE_TYPE_SO_CANCLE_FINISH_NOTIFY = "500150";// �����������֪ͨ

	public static final String HANDLE_TYPE_SO_CANCLE_FINISH_NOTIFY_INFO = "�����������֪ͨ";

	public static final String HANDLE_TYPE_SO_BOOK = "400140";

	public static final String HANDLE_TYPE_SO_BOOK_INFO = "����ԤԼ";
	
	public static final String HANDLE_TYPE_SO_BOOK_SENDDATE_TO_CRM = "����ԤԼ��CRMʱ��Ƭ";

	public static final String HANDLE_TYPE_RES_RELEASE_STEP = "220260";// ʧ�ܻص���Դ�ͷ�

	public static final String HANDLE_TYPE_RES_RELEASE_STEP_INFO = "ʧ�ܻص���Դ�ͷ�";

	public static final String HANDLE_TYPE_SO_MODIFY = "502000";// ���շ��򶨵�

	public static final String HANDLE_TYPE_SO_MODIFY_INFO = "�����޸�";

	public static final String HANDLE_TYPE_EXP_FORWARD_INVOKE = "500200";// �쳣����ǰ��

	public static final String HANDLE_TYPE_EXP_FORWARD_INVOKE_INFO = "�쳣����ǰ��";

	public static final String HANDLE_TYPE_EXP_BACKWARD_INVOKE = "500201";// �쳣���̺��

	public static final String HANDLE_TYPE_EXP_BACKWARD_INVOKE_INFO = "�쳣���̺��";

	public static final String HANDLE_TYPE_BW_WO_RESEND = "500202";// �����ط�

	public static final String HANDLE_TYPE_BW_WO_BACK = "500203";// ǿ�лص�

	public static final String HANDLE_TYPE_BW_WO_REVERSE = "500204";// ǿ�з���
	
	public static final String HANDLE_TYPE_CHANGE_SO_BOOK = "400141";//  �޸�ԤԼʱ��  for���� 
	
	public static final String HANDLE_TYPE_CHANGE_SO_BOOK_INFO = "CRM�޸�ԤԼ";
	
	public static final String HANDLE_TYPE_PRESSTYP_PRESS = "400200"; //�ɷ��ߵ�
	
	public static final String HANDLE_TYPE_PRESSTYP_MSG = "400201";  //�ɷ�����
	
	public static final String HANDLE_TYPE_PRESSTYP_OTHER = "400202"; //������ʽ
	
	public static final String HANDLE_TYPE_SPEC_PRPTY = "220300"; // ���Ի���

	public static final String HANDLE_TYPE_SPEC_PRPTY_INFO = "���Ի���";// ���Ի���

	// --------------��

	public static final String HANDLE_TYPE_SENDTO = "220172"; // ʩ������/����ת��

	public static final String HANDLE_TYPE_SUCCESS_RETURN = "220160";// �ص������ص�

	public static final String HANDLE_TYPE_FAIL_RETURN = "220161"; // �ص�ʧ�ܻص�

	public static final String HANDLE_TYPE_SEND_TO = "220171"; // �쵥�����ɷ�

	public static final String HANDLE_TYPE_BIDE_TO_COMFIRM = "220254";// ת��װȷ��

	public static final String HANDLE_TYPE_BIDE_COMFIRM = "220255";// װ��װ
	
	public static final String HANDLE_TYPE_DELAY_FIX = "220259";// ��װת��
	
	public static final String HANDLE_TYPE_DELAY_FIX_OUT = "220290";// ��װת��

	public static final String HANDLE_TYPE_EXPLORE = "220343"; // ת�⿱

	public static final String HANDLE_TYPE_FETCH_NOT_PRINT = "220173"; // ֻ�쵥δ��ӡ

	public static final String HANDLE_TYPE_FETCH_PRINTED = "220183"; // �쵥����ӡ

	public static final String HANDLE_TYPE_TO_MANUAL = "220200";// ͳһ��������ת�˹�����

	public static final String HANDLE_TYPE_NAI_FAIL = "220201";// ͳһ�������÷���ʧ��

	public static final String HANDLE_TYPE_NAI_FETCH = "220202";// ͳһ�����ӿڵ��óɹ�

	public static final String HANDLE_TYPE_EXP_RESEND = "220192"; // �쳣�����쳣�ط�

	public static final String HANDLE_TYPE_INVOKE_FAIL = "220196"; // �Զ��ӿڵ���ʧ��

	public static final String HANDLE_TYPE_DUE = "220170"; // ԤԼδ���ڹ���ԤԼ ???????

	public static final String HANDLE_TYPE_SYNC_REQUEST = "220330"; // ����ͬ��������

	public static final String HANDLE_TYPE_SYNC_RESPONSE = "220331"; // ����ͬ�����󷵻�

	public static final String HANDLE_TYPE_QUERY_REQUEST = "220332"; // ��Դ��ѯ����

	public static final String HANDLE_TYPE_ASSIGN_REQUEST = "220333"; // ��Դ��������

	public static final String HANDLE_TYPE_CANCEL_ASSIGN_REQUEST = "220334"; // ������Դ��������

	public static final String HANDLE_TYPE_ASSIGN_RESPONSE = "220335"; // ��Դ���÷���

	public static final String HANDLE_TYPE_CHECK_REQUEST = "222336"; // ��Դ�������

	public static final String HANDLE_TYPE_CHECK_RESPONSE = "220337"; // ��Դ��˷���

	public static final String HANDLE_TYPE_REVERSE_REQUEST = "220338"; // ������������

	public static final String HANDLE_TYPE_ARCHIVE_REQUEST = "220339"; // ��Դ�鵵����

	public static final String HANDLE_TYPE_REPLENISH_RESPONSE = "220340"; // ����Դ���ظ�����ͨϵͳ

	public static final String HANDLE_TYPE_REPLENISH_RESPONSE_INFO = "����Դ���ط���ͨ"; // ����Դ���ظ�����ͨϵͳ

	public static final String HANDLE_TYPE_CTO_SO_REQUEST = "220341"; // ��Դ��Ӵ޵�����

	public static final String HANDLE_TYPE_CTO_SO_RESPONSE = "220342"; // ��Դ��Ӵ޵�����

	public static final String HANDLE_TYPE_WAIT_SO_RESPONSE = "220344"; // ����Դ���ظ�����ͨϵͳ

	public static final String HANDLE_TYPE_RE_RECEIVE_SO = "220320";// CRM���·���

	public static final String HANDLE_TYPE_NAS_REBUILD = "220000";// ��Ԫ�ӿ��쳣����쳣�ط�

	public static final String HANDLE_TYPE_NAS_DOSUCESS = "220001";// ��Ԫ�ӿ��쳣���ǿ�гɹ�

	public static final String HANDLE_TYPE_BS_REBUILD = "220003";// Ƿ��ͣ���쳣�����쳣�ط�

	public static final String HANDLE_TYPE_BS_REMOVE = "220002";// ���Ƿ��ͣ������
	
	public static final String HANDLE_TYPE_BSWOHIS_REBUILD = "220004";// ͣ��״̬�����쳣�ط�

	public static final String HANDLE_TYPE_BSWOHIS_DOSUCESS = "220005";// ͣ��״̬����ǿ�Ƴɹ�

	public static final String SO_PARSE_SUCCESS = "220230";// ���������ɹ�

	public static final String SO_PARSE_SUCCESS_INFO = "���������ɹ�";// ���������ɹ�������Ϣ

	public static final String SO_PARSE_SUCCESS_REASON_INFO = "SO: SO_LOCK_STS ->N,SO_STS ->A";// ���������ɹ���������

	public static final String SO_MATCH_FAILED = "220231";// ����ƥ��ʧ��

	public static final String SO_MATCH_FAILED_INFO = "����ƥ��ʧ��";// ����ƥ��ʧ�ܴ�����Ϣ

	public static final String SO_MATCH_FAILED_REASON_INFO = "SO: SO_STS A->M";// ����ƥ��ʧ�ܾ�������

	public static final String WAITING_CHOICE_PROC = "220232";// �ȴ�ѡ������

	public static final String WAITING_CHOICE_PROC_INFO = "�ȴ�ѡ������";// �ȴ�ѡ�����̴�����Ϣ

	public static final String WAITING_CHOICE_PROC_REASON_INFO = "SO: SO_STS A->W";// �ȴ�ѡ�����̾�������

	public static final String WAITING_START_PROC = "220233";// �ȴ���������

	public static final String WAITING_START_PROC_INFO = "�ȴ���������";// �ȴ��������̴�����Ϣ

	public static final String WAITING_START_PROC_REASON_INFO = "SO: SO_STS A->D";// �ȴ��������̾�������

	public static final String PROC_START_SUCCESS = "220234";// ���������ɹ�

	public static final String PROC_START_SUCCESS_INFO = "���������ɹ�";// ���������ɹ�������Ϣ

	public static final String PROC_START_SUCCESS_REASON_INFO = "SO: SO_STS A->P";// ���������ɹ���������

	public static final String PROC_START_FAILED = "220235";// ��������ʧ��

	public static final String PROC_START_FAILED_INFO = "��������ʧ��";// ��������ʧ�ܴ�����Ϣ

	public static final String PROC_START_FAILED_REASON_INFO = "SO: SO_STS A->E";// ��������ʧ�ܾ�������

	public static final String PROC_INST_CREATE_SUCCESS = "220250";// ����Эͬ����ʵ�������ɹ�

	public static final String PROC_INST_CREATE_SUCCESS_INFO = "����Эͬ����ʵ�������ɹ�";// ����Эͬ����ʵ�������ɹ�������Ϣ

	public static final String PROC_INST_CREATE_SUCCESS_REASON_INFO = "����Эͬ����ʵ�������ɹ�";// ����Эͬ����ʵ�������ɹ���������

	public static final String PROC_INST_CREATE_FAILED = "220251";// ����Эͬ����ʵ������ʧ��

	public static final String PROC_INST_CREATE_FAILED_INFO = "����Эͬ����ʵ������ʧ��";// ����Эͬ����ʵ������ʧ�ܴ�����Ϣ

	public static final String PROC_INST_CREATE_FAILED_REASON_INFO = "����Эͬ����ʵ������ʧ��";// ����Эͬ����ʵ������ʧ�ܾ�������

	public static final String STEP_INST_CREATE_SUCCESS = "220252";// ����Эͬ����ʵ�������ɹ�

	public static final String STEP_INST_CREATE_SUCCESS_INFO = "����Эͬ����ʵ�������ɹ�";// ����Эͬ����ʵ�������ɹ�������Ϣ

	public static final String STEP_INST_CREATE_SUCCESS_REASON_INFO = "����Эͬ����ʵ�������ɹ�";// ����Эͬ����ʵ�������ɹ���������

	public static final String STEP_INST_CREATE_FAILED = "220253";// ����Эͬ����ʵ������ʧ��

	public static final String STEP_ISNT_CREATE_FAILED_INFO = "����Эͬ����ʵ������ʧ��";// ����Эͬ����ʵ������ʧ�ܴ�����Ϣ

	public static final String STEP_INST_CREATE_FAILED_REASON_INFO = "����Эͬ����ʵ������ʧ��";// ����Эͬ����ʵ������ʧ�ܾ�������

	public static final String CHANGE_SO_LOCK_STS_ID = "220270";// �ĵ�����

	public static final String CHANGE_SO_LOCK_STS_INFO = "�ĵ�����";

	public static final String CANCLE_SO_LOCK_STS_ID = "220271";// 220271

	public static final String CANCLE_SO_LOCK_STS_INFO = "��������";

	public static final String UN_SO_LOCK_STS_ID = "220272";// 220272

	public static final String UN_SO_LOCK_STS_INFO = "����";

	public static final String RE_RECEIVE_SO_ID = "220273";// �����ط���

	public static final String RE_RECEIVE_SO_INFO = "�����ط���";

	public static final String DELAY_SO_STS_ID = "220274";// 220274 ��װ

	public static final String DELAY_SO_STS_INFO = "��װ";

	public static final String RESUME_SO_STS_ID = "220275";// 220275 ��װ

	public static final String RESUME_SO_STS_INFO = "��װ";

	public static final String COMPL_PAY_NOTIFY_ID = "220276";// 220276 �շ����

	public static final String COMPL_PAY_NOTIFY_INFO = "�շ����";

	public static final String SO_MATCH_PROCESS_FAIL = "0"; // ����ƥ�䴦��ʧ��

	public static final String SO_MATCH_PROCESS_SUCCESS = "1";// ����ƥ�䴦��ɹ�

	public static final String SO_PROCESS_START_FAIL = "2";// ��������ʧ��

	public static final String HANDLE_TYPE_FAILRETURN_NEED_AUDIT = "220256"; // ��Ҫ���

	public static final String HANDLE_TYPE_FAILRETURN_FAIL_STAY = "220257"; // ʧ������

	public static final String HANDLE_TYPE_FAILRETURN_WAIT_WITHDRAW = "220258"; // �ȴ����ĵ�

	public static final String HANDLE_TYPE_ADD_PRINT_COUNT = "220278"; // ���ӹ�����ӡ����

	public static final String HANDLE_TYPE_CHECK_AUDIT_NOT_PASS = "220221";// ��˲�ͨ�����˻�ԭ��

	// --------------------------ϵͳcontext����
	public static final String CONTEXT_WFS = "wfs";// context-config.xml�й�������������

	public static final String CONTEXT_RMS = "rms";// context-config.xml����Դ��������

	public static final String CONTEXT_NAI = "nai";// context-config.xml����Դ��������

	// ----------------------------------Timer �ӿڣ�������������������������������������
	// TIMER�ͷ���ͨ��ʧ��ԭ����
	public static final String FAIL_CODE_ONE = "-1";// ������Դǰ�����쳣

	public static final String FAIL_CODE_TWO = "-2";// ������Դ�����쳣

	public static final String FAIL_CODE_ZERO = "0";// ������Դ�����쳣

	// ʩ������ҳ��
	public static final String STEP_PLUG_FLAG_YES = "0"; // �����־ 0

	/** *******************������ӡ����*********************************** */

	public static final float PAGELENGTH = 297;// ҳ�泤�� ��λmm

	public static final float PAGEWIDTH = 210;// ҳ���� ��λmm

	// ��ӡ���Ԫ�صĵ��÷�ʽ
	public static final String CALLTYPE_PROCEDURE = "P"; // ���÷�ʽ�Ǵ洢����

	public static final String CALLTYPE_JAVA = "J";// ���÷�ʽ��JAVA

	public static final String CALLTYPE_SQL = "S"; // ��̬SQL

	public static final String CALLTYPE_METHOD = "N"; // ����ʵ�֣������÷���

	public static final String PROCEDURE_PRINT_RES_PRPTY = "PRINT.PRINT_RES_PRPTY"; // ȡ��Դ��Ϣʱ�����õĴ洢��������
	
	public static final String PROCEDURE_PRINT_RELA_RES_AP = "PRINT.PRINT_RELA_RES_AP"; // ȡ��������Դ��Ϣʱ�����õĴ洢��������

	public static final String PROCEDURE_PRINT_MAIN_PROD_PRPTY = "PRINT.PRINT_MAIN_PROD_PRPTY"; // ȡ����Ʒ��Ϣʱ�����õĴ洢��������
	
	public static final String PROCEDURE_PRINT_MATCH_TEMPLATEID = "PRINT.PRINT_MATCH_TEMPLATEID"; // �ϵ�ʱ��ȷƥ��ģ��ID

	// public static final int RECORD_COUNT_PRE_PAGE = 10; // ʩ���ɵ����ӵ�ÿҳ��ʾ�ļ�¼��

	public static final String PRINT_RECORD_COUNT_PRE_PAGE = "70005"; // ʩ���ɵ����ӵ�ÿҳ��ʾ�ļ�¼��

	public static final String SPEC_TEMPLATE_ID = "100054"; // ʩ���ɵ����ӵ�ģ��id

	// public static final int SPACE_BETWEEN = 80; // ʩ���ɵ����ӵ���������¼�ļ��

	public static final String PRINT_SPACE_BETWEEN = "70004"; // ʩ���ɵ����ӵ���ÿ�������Ŀ��

	public static final float SPACE_LEFT = 10; // ʩ���ɵ����ӵ��������ڵ���߾�

	public static final int SPACE_TOP = 44; // ʩ���ɵ����ӵ�TITLE�Ķ��߾�

	public static final float SPACE_RIGHT = 740; // ʩ���ɵ����ӵ��ұ߾�

	public static final String PRINT_WORK_TYPE = "70001"; // �ɴ�ӡ���ӵ��Ĺ������͵�SYS_CONFIG_ID

	public static final String PRINT_HANDLE_OVER_TEMPLATE_ID = "70002"; // ���ӵ���template_id��SYS_CONFIG_ID

	public static final String PRINT_DEPARTMENT = "[WO100120]"; // ���ӵ��Ĳ��ŵ�sys_item_id

	public static final int SIMPLE_PRINT_COUNT_PREPAGE = 2; // ������λ�򵥹���ÿҳ��ӡ������

	public static final float SIMPLE_PRINT_SPAN = 370; // ������λ�򵥹��� ÿ��������ռ�߶�

	public static final String PRINT_AREA_ID = "[CI100120]"; // ������λ�򵥹���

	// ���ⲿ�ֵķ�������SYS_ITEM_ID

	public static final String PRINT_WORK_AREA_ID = "[WO100120]"; // ������λ�򵥹���

	// ���ⲿ�ֵĹ�������SYS_ITEM_ID

	public static final float SIMPLE_SPACE_LEFT = 500; // �����򵥹�����ӡ���ڵ���߾�

	public static final float SIMPLE_SPACE_TOP = 20; // �����򵥹�����ӡ���ڵĶ��߾�

	public static final String PRINT_SIMPLE_WORK_TYPE = "70006"; // �ɴ�ӡ�򵥹����Ĺ�������

	public static final String PRINT_SYS_ITEM_NO_FLAG_N = "N"; // sys_item����Ԫ�����table_name�����õı�û��no_flag�ֶ�,��Ӧ����no_flag='N'

	public static final String PRINT_FROM_M = "M"; // ģ���϶�̬Ԫ����Դ��������

	public static final String PRINT_FROM_S1 = "S1"; // ģ���϶�̬Ԫ����Դ�ڴӹ���1

	public static final String PRINT_FROM_S2 = "S2"; // ģ���϶�̬Ԫ����Դ�ڴӹ���2
	
	public static final String PRINT_FROM_N = "N"; // ģ���϶�̬Ԫ��������

	public static final String PRINT_MERGFLAG_Y = "Y"; // WO.MERG_FLAG = Y �Ѻϲ�

	public static final String PRINT_MERGFLAG_N = "N"; // WO.MERG_FLAG = N δ�ϲ�

	public static final String PRINT_MERGFLAG_W = "W"; // WO.MERG_FLAG = W ����ϲ�
	
	public static final String PRINT_PAPER_SIZE = "70007"; // ��ӡֽ�Ŵ�С
	
	public static final String SIMPLE_DATE_SPACE_LEFT = "70008"; // �򵥴�ӡʱ��ӡ�������ڵ���߾�
	
	public static final String SIMPLE_DATE_SPACE_TOP = "70009"; // �򵥴�ӡʱ��ӡ�������ڵĶ��߾�
	

	/** *******************�˵����*********************************** */
	// �쳣ǰ��
	public static final String MSG_SPS_WFS_EVENT_PROC_EXP_DISPATCH = "PROC_EXP_DISPATCH"; // �쳣�����˹�����(��ǰ����)

	// �쳣���
	public static final String MSG_SPS_WFS_EVENT_PROC_EXP_DISPATCH_FORWARD = "PROC_EXP_DISPATCH_FORWARD"; // �쳣�����˹�����(������)

	public static final String IS_WO_CHECK = "71006"; // ���Խ��й�����˹��ܵ����ùرտ���

	public static final String WORKFLOWDOEVENT_RET_CODE = "0"; // WfApiDOM().workFlowDoEvent()�ķ���ֵ

	// �����������ص�ֵ 0���óɹ�,ʧ���׳��쳣.

	// ���鵵��������ֵ
	public static final String CUR_TO_ARC_FAIL = "N";

	public static final String CUR_TO_ARC_SUCCESS = "Y";

	// ����CRM
	public static final String IS_CENTER_LOCAL_NET_Y = "Y";

	public static final String MAIN_FLAG_N = "N";

	public static final String MAIN_FLAG_Y = "Y";

	public static final String BUSINESS_TYPE_A = "A";

	/* S ����ͨ�ŷ���Ŀͻ��������� */
	public static final String BUSINESS_TYPE_COMM_SERV_SPEC = "S";

	/* ����ͨ�ŷ���ķ����� */
	public static final String ACT_ADD_ADD_PRODUCT = "3061"; // ����ͨ�ŷ���������ID

	public static final String STS_HISTORY = "P";

	public static final String STS_IN_USE = "A";

	public static final String SEQ_SPEC_PRPTY_INC_ID = "SPEC_PRPTY_INC_ID";// ��������

	public static final String BUSI_MATCH_ID = "BUSI_MATCH_ID";// ҵ��������¼����

	public static final String ORDER_MATCH_ID = "ORDER_MATCH_ID";// ����ƥ�������

	/* ��Ʒ����������ֵ���� */
	public static final String SPEC_PRPTY_VALUE_ID_SEQ = "SPEC_PRPTY_VALUE_ID";// ����ֵ���ñ��

	public static final String CONFIG_ID_CRM_FILL_BUILDING_URL = "88890";

	/* �ӿ�״ֵ̬ */
	public static final String SPJK_TABLE_STS_SEND_FAIL = "E";

	public static final String SPJK_TABLE_STS_WAIT_SEND = "D";

	public static final String SPJK_TABLE_STS_SEND_COMP = "P";

	public static final String SPJK_TABLE_STS_SUCCESS = "C";

	/* UBI */
	public static final int UBI_START_OFFSET = 0; // start field

	public static final int UBI_START_LENGTH = 4;

	public static final String UBI_START_VALUE = "`SF`";

	public static final int UBI_VERSION_OFFSET = 4;// version field

	public static final int UBI_VERSION_LENGTH = 4;

	public static final String UBI_VERSION_VALUE = "1.00";

	public static final String UBI_VERSION_NAME = "UBI_VERSION";

	public static final int UBI_LENGTH_OFFSET = 8;// length field

	public static final int UBI_LENGTH_LENGTH = 4;

	public static final String UBI_LENGTH_NAME = "UBI_LENGTH";

	public static final int UBI_SEQUENCE_OFFSET = 12;// sequence field

	public static final int UBI_SEQUENCE_LENGTH = 4;

	public static final String UBI_SEQUENCE_NAME = "UBI_SEQUENCE";

	public static final int UBI_TYPE_OFFSET = 16;// type field

	public static final int UBI_TYPE_LENGTH = 4;

	public static final String UBI_TYPE_NAME = "UBI_TYPE";

	public static final String UBI_INFO_NAME = "UBI_INFO";

	public static final String UBI_TYPE_LGIN = "LGIN";

	public static final String UBI_TYPE_LGOT = "LGOT";

	public static final String UBI_TYPE_INFO = "INFO";

	public static final String UBI_TYPE_TEST = "TEST";

	public static final int UBI_INFO_OFFSET = 20;// infomation field

	public static final String UBI_INFO_OK = "OK";

	public static final String UBI_INFO_ERR = "ERROR";

	public static final String UBI_INFO_TEST = "HBTEST";

	public static final int UBI_END_LENGTH = 4;// end field

	public static final String UBI_END_VALUE = "`EF`";

	public static final int UBI_HEAD_LEN = 20; // head length

	public byte[] head = new byte[UBI_HEAD_LEN];// head bytes

	/* ͳһ������������ַ */
	public static final String SOCKET_SERVER_CONFIG_ID = "90000";

	public static final String SYS_ITEM_ID_SEQ = "SYS_ITEM_ID";// ϵͳԪ�ر���

	/* ��ɱ�־ USER_DATA_RANGE */
	public static final String ALLOW_FLAG_READ = "R";

	public static final String ALLOW_FLAG_ADD = "A";

	public static final String ALLOW_FLAG_UPDATE = "U";

	public static final String ALLOW_FLAG_DELETE = "D";

	public static final String ALL0W_FLAG_QUERY = "Q";
	// ��ʾ����Ȩ��У��
	public static final String ALL0W_FLAG_NOLIMIT = "Y";

	/* �������ͣ���ӦUSER_DATA_RANGE.RANGE_TYPE_ID */
	public static final String AREA_TYPE_LOCAL_NET = "L";

	public static final String AREA_TYPE_AREA = "A";

	public static final String BACKFILL_FLAG_SUCCESS = "Y";

	public static final String BACKFILL_FLAG_FAIL = "F";

	/* ��������ʵ���� SO_SI_GROUP */
	// public static final String GROUP_TYPE_ID_DEFAULT = "S";
	public static final String SO_SI_GROUP_MEMBER_STS_IN_USE = "A";

	/* ����������Ϣ SO_CHARGE */
	public static final String SO_CHARGE_LOCAL_NET_ID_DEFAULT = "0";

	public static final String SO_CHARGE_SO_NBR_DEFAULT = "0";

	public static final String SO_CHARGE_NO_FLAG_DEFAULT = "A";// ��

	public static final String SO_CHARGE_CHARGE_DEFAULT = "0";

	public static final String SO_CHARGE_PAY_FLAG_DEFAULT = "Y";// �Ѹ���

	public static final String SO_CHARGE_HOME_BILL_FLAG_DEFAULT = "N";// ���Ų���

	public static final String SO_CHARGE_STS_DEFAULT = "A";// ��Ч

	public static final String SO_CHARGE_PAY_FLAG_NO = "N";// δ����

	/* �Ƿ������ͷ���Դ�ı�־WO��STEP_FAIL_REASON */
	public static final String RES_RELEASE_FALG_YES = "Y";

	public static final String RES_RELEASE_FALG_NO = "N";

	/* ���ɹ�����ʽ */
	public static final String REAL_TIME_STATUS_NN = "NN"; // ��ʵʱ����
	// ǰһλ����ʵʱ��־����һλ���������쳣

	public static final String REAL_TIME_STATUS_YN = "YN"; // ʵʱ����

	public static final String REAL_TIME_STATUS_YE = "YE"; // ʵʱ�쳣

	/* Ⱥ���Ƿ����仯�ı�־ */
	public static final String GROUP_CHANGE_FLAG_FOR_YES = "Y"; // Ⱥ�鷢���仯

	public static final String GROUP_CHANGE_FLAG_FOR_NO = "N"; // Ⱥ��δ�����仯

	/* �¾�Ⱥ���־ */
	public static final String GROUP_NOFLAG = "AP";// ֵδ���κκ���

	/* ��Ⱥ���������ѡ���־ */
	public static final String OLD_GROUP_PARSE_FLAG = "S";

	/* �Ǿ��������� */
	public static final String DEFAULT_LOCAL_NET_ID = "0"; // Ĭ�ϱ�����ID

	public static final String ALL_LOCAL_NET_ID = "0"; // ���б�����

	public static final String SYS_LOCAL_NET_ID = "999"; // ϵͳ������

	public static final int ARC_DEAL_COUNT = 3;

	public static final String ALL_AREA_ID = "0"; // ���з�����

	public static final String ALL_EXCH_ID = "0"; // ���о���

	public static final String ALL_SERV_DEPT_ID = "0"; // ����Ӫά����

	/* ��־�������� */
	public static final String ACTION_LOG_SPEC_PRPTY = "����:";

	public static final String ACTION_LOG_SPEC_PRPTY_VALUE = "����ֵ:";

	// ϵͳԪ�ر�FOR_SCENE�Ķ���
	public static final String SYS_ITEM_FOR_SCENE_WO_PRINT = "WO_PRINT"; // ������ӡ
	public static final String SYS_ITEM_FOR_SCENE_SO_MATCH = "SO_MATCH"; // ����ģ��ƥ��
	public static final String SYS_ITEM_FOR_SCENE_WO_PRPTY = "WO_PRPTY"; // ��������ȡֵ

	/* �����޸ļ�¼ */
	public static final String PRPTY_CHANGE_LOG_ID_SEQ = "PRPTY_CHANGE_LOG_ID";// ����ֵ

	public static final String LOG_TYPE_FILL_BACK = "F";// ��־����Ϊ���Ի���
	public static final String RETURN_TYPE_NORMAL = "C";// �ص�����Ϊ����

	// ��������־
	public static final String MAIN_WO_Y = "Y";
	public static final String MAIN_WO_N = "N";
	// ʩ����������ӿڳ�������WW

	// ����ȡֵ������־
	public static final String DEP_FLAG_Y = "Y";
	public static final String DEP_FLAG_N = "N";

	public static final String SYS_CONFIG_ORG_DEPT = "71003";// �������Ŧ��ʾ����
	public static final String SYS_CONFIG_STAFF = "71004";
	
	public static final String SYS_CONFIG_MAINT_AREA = "71024";//��������ť��ʾ����

	public static final String EXCH_ID_SEQ = "EXCH_ID"; // ����ID

	public static final String SYS_CONFIG_STEP_POWER_CONFIG = "71007";// ����Ȩ�����ÿ���

	public static final String ACTION_LOG_STEP_DESIGN_MATCH = "�������ƥ��Ҫ��:";

	public static final String ACTION_LOG_STEP_DESIGN = "�������:";

	/* ����ר���漰�ĸ���������� */
	public static final String BW_DESIGN_TYPE_FREE_FLOW = "F";// ���������

	public static final String BW_DESIGN_TYPE_WO_FACTORS = "W";// �����������

	public static final String BW_DESIGN_TYPE_RES_ASSIGN = "R";// ��Դ���÷������

	public static final String BW_DESIGN_TYPE_KEYVALUE = "K";// ���֧·�����
	
	public static final String BW_DESIGN_TYPE_FAULT_RELATION = "D";// �ϰ������������
	
	public static final String SA_DESIGN_TYPE_MAN_DISPATCH = "A";// �������Զ�·�����
	
	public static final String SA_CUST_NAME ="�޿ͻ���Ϣ"; //�����Ͽͻ���������
	public static final String SA_CUST_Id="1000001";//�����Ͽͻ�����ID


	/* Ŀ��������� */
	public static final String BW_OBJ_TYPE_NAME_STEP = "����";

	public static final String BW_OBJ_TYPE_NAME_RES_SERV = "��Դ����";

	/* ���ϵͳ */
	public static final String BW_SYSTEM_SPS = "SPS";

	public static final String BW_SYSTEM_RMS = "RMS";

	/* Ŀ��������� */
	public static final String BW_OBJ_TYPE_STEP = "S";

	public static final String BW_OBJ_TYPE_KEYVALUE = "K";

	public static final String BW_OBJ_TYPE_RES_SERV = "R";

	/* ǰ�ö������� */
	public static final String BW_PRE_OBJ_TYPE_STEP = "S";

	public static final String BW_PRE_OBJ_TYPE_NODE = "N";

	/* ���״̬ */
	public static final String BW_DESIGN_STS_DESIGN = "D";// ����״̬

	// �ݲ�������������ƽ����״̬��ǨΪ"C"ȷ��״̬��
	public static final String BW_DESIGN_STS_CONFIRM = BW_DESIGN_STS_DESIGN;//"C";// Ԥ��

	public static final String BW_DESIGN_STS_EXECUTE = "E";// �ع���

	/* ������Ʊ�ʶ */
	public static final String BW_FREE_FLOW_FLAG_YES = "Y";

	public static final String BW_FREE_FLOW_FLAG_NO = "N";

	/* ������(sub_flow_list)���������ȡֵ */

	public static final String SUB_FLOW_PARAMLIST_PROC_NODE_LIMIT_PRE_ALARM_CODE = "PROC_NODE_LIMIT_PRE_ALARM";// Ԥ��ʱ��

	public static final String SUB_FLOW_PARAMLIST_PROC_NODE_LIMIT_ALARM_CODE = "PROC_NODE_LIMIT_ALARM";// �澯ʱ��

	public static final String SUB_FLOW_PARAMLIST_PROC_NODE_LIMIT_HASTEN_CODE = "PROC_NODE_LIMIT_HASTEN";// �ߵ�ʱ��

	public static final String SUB_FLOW_PARAMLIST_PROC_NODE_LIMIT_METRIC = "PROC_NODE_LIMIT_METRIC";// ʱ�޵�λ

	public static final String SUB_FLOW_PARAMLIST_PROC_NODE_LIMIT_CREATE_STAFF_ID = "PROC_NODE_LIMIT_CREATE_STAFF_ID";// ʱ�޴�����Ա

	public static final String SUB_FLOW_PARAMLIST_PROC_NODE_LIMIT_CREATE_DATE = "PROC_NODE_LIMIT_CREATE_DATE";// ʱ�޴���ʱ��

	public static final String SUB_FLOW_PARAMLIST_PROC_NODE_LOCAL_NET_ID = "LOCAL_NET_ID";

	public static final String SUB_FLOW_PARAMLIST_PROC_NODE_WORK_AREA_ID = "WORK_AREA_ID";
	
	public static final String SUB_FLOW_PARAMLIST_PROC_NODE_AREA_ID = "AREA_ID";

	public static final String SUB_FLOW_PARAMLIST_PROC_NODE_WO_STAFF_ID = "WO_STAFF_ID";

	
	/* �쳣����ǰ�����־ */
	public static final String BW_EXP_FORWARD_INVOKE = "0";// �쳣ǰ��

	public static final String BW_EXP_BACKWARD_INVOKE = "1";// �쳣���

	/* ·����Ϣ��ѯ */

	public static final String ROUTER_NODE_DESC = "NODE_DESC";

	public static final String ROUTER_DESIGN_NODE_INSTANCE_ID = "DESIGN_NODE_INSTANCE_ID";

	public static final String ROUTER_KEY_VALUE = "KEY_VALUE";
	
	public static final String ROUTER_EXPRESS_NODE_INSTANCE_ID = "EXPRESS_NODE_INSTANCE_ID";

	/* ��ƹ������ɵ�״̬ */
	public static final String WO_DESIGN_DETAIL_DESIGN_DETAIL_STS_READY = "A";// ����

	public static final String WO_DESIGN_DETAIL_DESIGN_DETAIL_STS_COMPLATE = "C";// ���

	/** �ӿ�ȫ��������ر��� */
	public static final String conn_Y = "Y"; // ��ͨ����

	public static final String conn_N = "N"; // ��ͨʧ��

	public static final String SYS_CONFIG_NAS_SOCKET = "80000";// NAS�ӿ����ڽ���SOCKET���ӵ�IP�Ͷ˿�

	public static final String IM_CRM = "1";// ���CRM�ӿ�inter_id

	public static final String IM_RMS = "2";// ���RMS�ӿ�inter_id

	public static final String IM_NAS = "3";// ���NAS�ӿ�inter_id

	public static final String IM_BILL = "4";// ���NAS�ӿ�inter_id

	public static final String SYS_IMMONITOR_CONFIG_ID = "90007";// ���NAS�ӿ�inter_id
	
	public static final String SYS_STAFF_CONFIG_ID ="110021";//Ѳ����Ա�ֲ�ˢ����������id
	
	public static final String APPLI_PROCESS_STATUS_CONFIG_ID = "90008";// ��̨�����ͼ �ӿ�inter_id

	/* ������������(�������ع������) */
	public static final String PARAMETER_OBJ_TYPE_PROC = "P";

	public static final String PARAMETER_OBJ_TYPE_NODE = "N";

	public static final String PARAMETER_OBJ_TYPE_ACTIVITY = "A";

	public static final String BIND_REL_COLUMN = "relColumn";

	// ���ƻ������ݹ����� added by yangkai 2009-04-24
	public static final String CERT_TYPE_ID_SEQ = "CERT_TYPE_ID";// ֤����������

	public static final String CUST_LEVEL_ID_SEQ = "CUST_LEVEL_ID";// �ͻ���������

	public static final String CUST_VOCA_ID_SEQ = "CUST_VOCA_ID";// �ͻ���ҵ����

	public static final String CUST_CAT_ID_SEQ = "CUST_CAT_ID";// �ͻ���������

	/** ������ݲ�ѯ ��������id */
	public static final String SYS_CONFIG_QUICK_QUERY = "71008";
	
	/** ������ݲ�ѯ ��ѯ��Ŀ����id */
	public static final String SYS_CONFIG_QUICK_QUERY_NUMBER = "71009";

	// �鿴���й���״̬����
	public static final String SYS_CONFIG_PARALLEL_WO_RUN_STS_FLAG = "70011";

	// ���ȼ���������
	public static final String SO_PRIORITY_ID_SEQ = "SO_PRIORITY_ID";// ֤����������

	// inter_service_order��״̬
	public static final String INTER_SERVICE_ORDER_STS_A = "A";

	public static final String INTER_SERVICE_ORDER_STS_B = "B";

	public static final String INTER_SERVICE_ORDER_STS_C = "C";

	public static final String INTER_SERVICE_ORDER_STS_D = "D";

	public static final String INTER_SO_EXCEPTION_STS_C = "C";

	// added by yangkai 2009-06-10
	public static final String GROUP_SPEC_SPS_ID_SEQ = "GROUP_SPEC_SPS_ID";// Ⱥ��������

	public static final String BUSI_RULE_ID_SEQ = "BUSI_RULE_ID";// ҵ���������

	// added by yangkai 2009-06-11
	public static final String ACT_TYPE_MAP_ID_SEQ = "ACT_TYPE_MAP_ID";// ����ӳ������

	// added by yangkai 2009-06-15
	public static final String STEP_SPEC_SERV_ID_SEQ = "STEP_SPEC_SERV_ID";// ����רҵ��������

	// add by liyaquan 2009-06-10
	// no_flagת��
	public static final String BIZ_EXCH_TYPE_AP = "NOFLAG_AP";
	public static final String BIZ_EXCH_TYPE_P = "NOFLAG_P";
	public static final String BIZ_PRPTY_TYPE_FLAG = "NO_FLAG";
	public static final String BIZ_TYPE_FLAG = "CHG_SERV_SPEC";

	// so���¼״̬Ϊ����
	public static final String SO_STS_A = "A";
	
	/* �ع���ʽ*/
	public static final String REBUILD_MODE_MANUAL = "M"; // ���˹���ƽ���ع�
	
	public static final String REBUILD_MODE_AUTO = "A"; // ������Ȩ���ع�
	
	/* �������*/
	public static final String RESOURCE_DESIGN_RESPONSE_DESIGN_TYPE_RES = "0";// ����Դ����

	public static final String RESOURCE_DESIGN_RESPONSE_DESIGN_TYPE_RES_SORT = "1";// ��Դ�����˳�����

	//GROUP_TYPE.TO_OBJ_TYPE 	 ADD BY YIYI
	public static final String GROUP_TYPE_TO_OBJ_TYPE_WO = "WO";
	
	public static final String GROUP_TYPE_TO_OBJ_TYPE_SO = "SO";
	
	public static final String WO_PRESS_TYPE_PRE_ALARM = "P";
	public static final String WO_PRESS_TYPE_ALARM = "A";

	/**SLAģ������,SLAĿ¼*/
	public static final String SLA_TEMPLATE_ID_SEQ = "SLA_TEMPLATE_ID"; //SLAģ��Ԫ��
	
	public static final String SLA_ELEMENT_ID_SEQ = "SLA_ELEMENT_ID"; //SLAģ��Ԫ��
	
	public static final String SYS_CONFIG_SURVEY_WORKTYPEID = "40040";
	
	/*-------------���̸�Ԥ���ٲ�ѯ����--------------*/
	public static final String WF_ADJUST_QUERY_RECENT_START = "1";// �������

	public static final String WF_ADJUST_QUERY_RECENT_ACTIVITY = "2";// ����

	public static final String WF_ADJUST_QUERY_RECENT_LOCK = "3";// �������

	public static final String WF_ADJUST_QUERY_ANCIENT_ACTIVITY = "4";// ���δ�
	
	/*-------------֪ͨ��������&�����߶�������--------------*/
	
	public static final String SENDER_TYPE_SYSTEM="S";//֪ͨ������Ϊϵͳ
	public static final String SENDER_TYPE_PERSON="P";//֪ͨ������Ϊ����
	
	public static final String OBJECT_TYPE_PROVINCE = "P"; //ʡ
	
	public static final String OBJECT_TYPE_LOCAL_NET = "L"; //������
	
	public static final String OBJECT_TYPE_AREA = "A"; //������
	
	public static final String OBJECT_TYPE_WORK_AREA = "W"; //����
	
	public static final String OBJECT_TYPE_STAFF = "S"; //Ա��
	
	public static final String OBJECT_TYPE_SYSTEM="S";
	public static final String FROM_OBJECT_TYPE_SYSTEM = "S"; //���Ͷ�������  ϵͳ
	public static final String FROM_OBJECT_TYPE_PROVINCE = "D"; //���Ͷ������� ʡ
	public static final String FROM_OBJECT_TYPE_LOCAL_NET  = "L"; //���Ͷ������� ������
	public static final String FROM_OBJECT_TYPE_AREA = "A"; //���Ͷ������� ������
	public static final String FROM_OBJECT_TYPE_WORK_AREA = "W"; //���Ͷ�������
	public static final String FROM_OBJECT_TYPE_PERSON = "P"; //���Ͷ�������
	
	public static final String TO_OBJECT_TYPE_SYSTEM = "S"; //���ն�������  ϵͳ
	public static final String TO_OBJECT_TYPE_PROVINCE = "D"; //���ն������� ʡ
	public static final String TO_OBJECT_TYPE_LOCAL_NET  = "L"; //���ն������� ������
	public static final String TO_OBJECT_TYPE_AREA = "A"; //���ն������� ������
	public static final String TO_OBJECT_TYPE_WORK_AREA = "W"; //���ն�������
	public static final String TO_OBJECT_TYPE_PERSON = "P"; //���ն�������
	
	//MSG_MATCH.OBJECT_TYPE��������
	public static final String OBJECT_TYPE_STEP = "STEP";//STEP ʩ������
	
	public static final String OBJECT_TYPE_SPSV = "SPSV";//SPSV  רҵ����
	
	public static final String OBJECT_TYPE_CKPT = "CKPT";//CKPT  ���ָ��
	/*����������ʡһ����*/
	public static final String CHECK_RULE_OBJECT_ID = "10001";  
	//ͨ��OSSͳһ�Ż���½֮��Ĭ��ת��Ӧ��
	public static final String SSO_DEFAULT_APP ="Y";
	
	public static final String FAULT_WORK_TYPE_ID="215006"; //�ϰ����޹�������id
	
	
	
	//MSG_MATCH.EVENT_TYPE �¼�����
	public static final String EVENT_TYPE_S = "S"; // �ɵ���ָ�ɡ�ת��֪ͨ
	
	public static final String EVENT_TYPE_D = "D"; // ��������֪ͨ
	
	public static final String EVENT_TYPE_P = "P"; // �쵥֪ͨ
	
	public static final String EVENT_TYPE_U = "U"; // �ߵ�֪ͨ
	
	public static final String EVENT_TYPE_C = "C"; // �˵�֪ͨ
	
	public static final String EVENT_TYPE_B = "B"; // ԤԼ֪ͨ
	
	public static final String EVENT_TYPE_R = "R"; // �ص�֪ͨ
	
	public static final String EVENT_TYPE_T = "T"; // ת��֪ͨ
		
	public static final String EVENT_TYPE_A = "A"; // �澯֪ͨ
	
	public static final String EVENT_TYPE_W = "W"; // Ԥ��֪ͨ
	
	public static final String EVENT_TYPE_H = "H"; // ����֪ͨ
	
	public static final String EVENT_TYPE_N = "N"; // ����֪ͨ
	
	public static final String EVENT_TYPE_M = "M"; // MOS��Ϣ����
	
	public static final String EVENT_TYPE_S_INFO = "�ɵ���ָ�ɡ�ת��֪ͨ"; // �ɵ���ָ�ɡ�ת��֪ͨ
	
	public static final String EVENT_TYPE_R_INFO = "�ص�֪ͨ"; // �ص�֪ͨ
	
	public static final String EVENT_TYPE_P_INFO = "�쵥֪ͨ"; // �쵥֪ͨ
	
	public static final String EVENT_TYPE_U_INFO = "�ߵ�֪ͨ"; // �ߵ�֪ͨ
	
	public static final String EVENT_TYPE_C_INFO = "�˵�֪ͨ"; // �˵�֪ͨ
	
	public static final String EVENT_TYPE_B_INFO = "ԤԼ֪ͨ"; // ԤԼ֪ͨ
	
	public static final String EVENT_TYPE_T_INFO = "ת��֪ͨ";
	
	public static final String EVENT_TYPE_A_INFO = "Ԥ���澯֪ͨ"; // Ԥ���澯֪ͨ
	
	public static final String MSG_EVENT_TYPE_SO = "SO"; //ҵ�񶨵�
	
	public static final String MSG_EVENT_TYPE_WO = "WO"; //ʩ������
	
	public static final String MSG_EVENT_TYPE_TO = "TO"; //ʩ������
	
	public static final String MSG_EVENT_TYPE_AL = "AL"; //Ԥ���澯
	
	public static final String MSG_EVENT_TYPE_MOS = "F";//MOS ����֪ͨ
	
	public static final String MSG_EVENT_TYPE_MOS_PUSH = "MOS";//MOS��Ϣ����

	public static final String MSG_MATCH_ID = "9476";//MOS ����֪ͨ
	
	public static final String MSG_SURVEY_ID = "9480";//MOS �ط�֪ͨ
	//MSG.STS
	
	public static final String MSG_STS_D = "D"; //�ȴ�����
	
	public static final String MSG_STS_P = "P"; //�Ѿ�����
	
	public static final String MSG_STS_E = "E"; //����ʧ��
	
	public static final String MSG_STS_C = "C"; //���ͳɹ�
	
	public static final String MSG_STS_R = "R"; //�Ѿ�����
	
	//MSG.MSG_TYPE
	public static final String MSG_TYPE_PARSE_BILLING = "BP";  //inter_msg_center.msg_type
	
	public static final String MSG_TYPE_PARSE_SO = "SP"; //inter_msg_center.msg_type
	
	public static final String MSG_TYPE_MATCH_BILLING = "BM"; //so_msg_center.msg_type
	
	public static final String MSG_TYPE_MATCH_SO = "SM"; //so_msg_center.msg_type
	
	public static final String MSG_TYPE_MATCH_SA = "SA";//so_msg_center.msg_type
	
	public static final String MSG_TYPE_PARSE_CO = "CP"; //�����ͻ������������汾��
 
	
/*--------------------------ʩ������----------------------------*/
	public static final String LOCAL_NET_ID_ALL = "0"; //���б�����
	
	public static final String LOCAL_NET_ID_SYS = "999"; //ϵͳ������
 
	
/*------------------��ѯ��� �Ե�@2009-7-15--------------------*/
	
	public static final String SIMPLE_QUERY = "1"; //�򵥲�ѯ
	
	public static final String ADVANCE_QUERY = "2"; //�߼���ѯ
	
	public static final String QUICK_QUERY="3"; //��ݲ�ѯ 
	
	
	//added by yangkai 2009-8-6
	public static final String IM4CRMService="IM4CRMService"; //Web Service��ΪIM4CRMService
	public static final String IM4BillingService="IM4BillingService"; //Web Service��ΪIOM4BillService
	public static final String CrmService="CrmService"; //Web Service��ΪCrmService
	public static final String BillService="BillService"; //�Ʒ��ṩ��WebService��
	public static final String WtsService = "ForSps6InterFace"; // ʩ�������ṩ��WebService��
	public static final String DEFAULT_VALUE="-1";//����������������Ϣ���в���Ĭ��ֵ-1
	public static final String MSG_TYPE_BP="BP";//����������������Ϣ���в�����Ϣ����ΪĬ��ֵBP
	public static final String SYS_CONFIG_WSURL_BILLING ="110001"; //sys_config �Ʒ��ṩ��Webservice��URL
	public static final String SYS_CONFIG_WSURL_CRM ="110000"; //sys_config CRM�ṩ��Webservice��URL
	public static final String SYS_CONFIG_WSURL_RMS ="110002"; //sys_config RMS�ṩ��Webservice��URL
	public static final String SYS_CONFIG_WSURL_LOCAL ="110003"; //sys_config ��ϵͳ�����ṩ��Webservice��URL
	public static final String SYS_CONFIG_WSURL_WTS ="110004"; //sys_config WTS�ṩ��Webservice��URL
	public static final String RMS_SERVICE = "Sps2RmsService"; // ��Դ�ṩ��webservice����
	// add by peiyy
	public static final String SYS_CONFIG_WSURL_SMS = "110018"; // ����CRM����webserviceURL
	public static final String SMS_SERVICE = "SmsService"; // �������Žӿ�webservice
    public static final String FUNCODE_WORK_AREA_AND_STAFF = "queryWorkAreaStaff";//
    public static final String FUNCODE_UPDATE_CHANGE_ORDER = "updateChangeOrder";//
    public static final String FUNCODE_SEND_TO_WITH_AUDIT = "sendToWithAudit";//MOSת��ǰ���

	// add by yanxin
	public static final String SYS_CONFIG_WSURL_BLOCK = "110022"; // פ�����½��ӿ�webserviceURL
	public static final String BlockService="BlockService"; //פ�����½��ӿ�WebService
	public static final String SYS_CONFIG_BLOCK_PROD_PRPTY = "225050"; // פ�����ӿ�����Ʒ����
	public static final String SYS_CONFIG_CREATE_BLOCK_PROD_PRPTY_VALUE = "225051"; // פ�����½��ӿ�����Ʒ����ֵ
	public static final String SYS_CONFIG_EXTEND_BLOCK_PROD_PRPTY_VALUE = "225052"; // פ�������ݽӿ�����Ʒ����ֵ
	
	//added by yangkai 2009-8-17
	public static final String DATASET_LEVEL="0";// Ĭ��WF_WORK_DAY_TIME����Ϊ"ȫ��"
	public static final String WORK_DAY_TIME_ID_SEQ="WORK_DAY_TIME_ID";// ��������������
	public static final String WORK_DAY_TIME_LIST_ID_SEQ="WORK_DAY_TIME_LIST_ID";// ��������������
	public static final String AreaTypeName="������";// Ĭ��Ϊ������
	public static final String STATE="0";// ״̬Ϊ����
	
	public static final String PRESS_TYPE_PRESS ="P";// ���ɴߵ�
	public static final String PRESS_TYPE_MSG ="S";// ���ɶ���
	public static final String PRESS_TYPE_OTHER ="O";// ����
	
	/*--------------------------------���̽�ģFlex-------------------��ʼ------------------------*/
	
	public static final String PROCESS_TYPE_ADJUST = "WORKFLOW_ADJUST";// ���̵���
	public static final String PROCESS_TYPE_DESIGN = "WORKFLOW_DESIGN";// �������
	
	public static final String CONECT_SYMBOL = "-"; // ���ӷ�
	public static final String FIRST_NODE_CODE = "01"; // ��һ���ڵ��ʶ
	public static final String DESIGN_BYMAN = "Y";  //�˹���ƻ
	public static final String WF_PROC_NODE_SEQ = "WF_PROC_NODE_ID";
	public static final String WF_PROC_INST_SEQ = "PROC_INST_ID";
	public static final String WF_PROC_NODE_INST_SEQ = "PROC_NODE_INST_ID";
	public static final String WF_PROC_NODE_PARAM_SEQ = "WF_PROC_NODE_PARAM_ID";
	public static final String WF_EXP_FLOW_INST_SEQ = "WF_EXP_FLOW_INST_ID";
	public static final String WF_EXP_FLOW_SEQ = "EXP_FLOW_ID";
	public static final String WF_EXP_FLOW_ACTIVITY_REGION_SEQ = "EXP_FLOW_ACT_REGION_ID";
	public static final String WF_EXP_FLOW_REGION_INST_SEQ = "WF_EXP_FLOW_REGION_INST_ID";
	public static final String WF_EXP_FLOW_REGION_SEQ = "EXP_FLOW_REGION_ID";
	public static final String WF_EXP_FLOW_NODE_SEQ = "WF_EXP_FLOW_NODE_SEQ";
	public static final String WF_EXP_FLOW_NODE_INST_SEQ = "WF_EXP_FLOW_NOD_INST_SEQ";
	public static final String ORIGIN_METHOD_PROCESS_IMPORT = "PROCESS_IMPORT"; //����Ǵ����̵��뷽��������XML
	/*--------------------�ڵ�����-------------------------------------*/
	static public final String NODE_TYPE_PROC_NO = "1"; // ��ڵ�

	static public final String NODE_TYPE_EXPRESS = "2"; // �����ڵ�

	static public final String NODE_TYPE_VIR = "3"; // α�ڵ�
	
	static public final String NODE_TYPE_CPN = "4"; //�����̽ڵ�
	
	public static final String LOOP_NODE = "1"; // ���ڽڵ�
	public static final String FALSE_NODE = "3"; // α�ڵ�
	public static final String CONDITION_NODE = "2"; // �����ڵ�
	public static final String LIMIT_USE_FLAG_A = "A";  //A:ʹ�ûʱ��(wf_activity_limit)
	public static final String LIMIT_USE_FLAG_N = "N"; //N:ʹ�ýڵ�ʱ��(wf_proc_node_limit)
	public static final String LIMIT_USE_FLAG_I = "I"; // I:ʹ�ýڵ�ʵ��ʱ��(wf_proc_node_inst_limit)
	public static final String LIMIT_STATE_NO_USE = "1";  //1 :ʱ�ޱ��STATE�ֶ�;1 ���� ;0 ����
	public static final String LIMIT_STATE_USE = "0";  //0 :ʱ�ޱ��STATE�ֶ�;1 ���� ;0 ����
	public static final String CONECT_BY_AND = "2"; // ��������
	public static final String CONECT_BY_SEQ = "1"; // ��������
	public static final String PARAMTYPE_FIXED = "1";

	public static final String PARAMTYPE_IF_ELSE = "2";
	public static final String PARAMTYPE_EXPRESS = "4";
	
	public static final String PARAMTYPE_MAN = "3";
	
	// ���������ʾ��wf_proc��������������
	public static final String LOCALNET = "������"; // ��ӦL
	public static final String AREA = "������"; // ��ӦA
	public static final String WORKAREA = "������"; // ��ӦW	
	
	// �ڵ�����
	public static final String NODE_TYPE_ACTIVITY = "ACTIVITY";
	public static final String NODE_TYPE_ROUTE = "ROUTE";
	public static final String NODE_TYPE_JOIN = "JOIN";
	public static final String NODE_TYPE_START = "START";
	public static final String NODE_TYPE_END = "END";
	public static final String ROUTE_TYPE_AND = "AND";
	public static final String ROUTE_TYPE_CONDITION = "CONDITION";
	public static final String ROUTE_TYPE_CASE = "CASE";
	public static final String ROUTE_TYPE_MAN = "MAN";
	public static final String NODE_TYPE_SUBPROC ="SUBPROC";
	
//	 ExpressType
	public static final String EXPRESS_TYPE_PROC = "1";

	public static final String EXPRESS_TYPE_NODE = "2";

	public static final String EXPRESS_TYPE_TIME= "3";
	//area_type_desc
	public static final String AREA_TYPE_LOCALNETDESC = "������"; // ��ӦL
	public static final String AREA_TYPE_AREADESC = "������"; // ��ӦA
	public static final String AREA_TYPE_WORKAREADESC = "������"; // ��ӦW
	
    /*----------------------------------���������ڵ�id-------------------------------------*/
    public static final String ROOT_CATALOG_ID = "0";	
    
    /*----------------------------------���̱�ʶ-------------------------------------*/
    public static final String PROC_TYPE_SUB_PROC = "SUBPROC";
    public static final String PROC_TYPE_PROC_SAVE_AS = "PROC_SAVE_AS";
    public static final String PROC_TYPE_PROC_MOVE_TO = "PROC_MOVE_TO";
    public static final String PROC_TYPE_PROC_PRIV = "PROC_PRIV";
    
	/*****************************���̼���*******************************/
	public static final String PROC_CAT_CHILD = "C";// ������
	public static final String PROC_CAT_PARENT = "P";// ������
	
	/** *************************���̰汾****************************** */
	
	public static final String PROC_VERSION = "PROC_VERSION";
	public static final String PROC_VERSION_SIGN = "V";//�汾��ʶ
	public static final String PROC_DEFAULT_VERSION = "V1.0";
	
	public static final String ZERO_CODE = "0"; // ��
	public static final String CUST_NAME_FOR_NON = "δ֪";
	
	public static final String EXTENDED_ATTRIBUTE_ROUTE_PARAM_ID = "ROUTE_PARAM_ID";
    
    public static final String EXTENDED_ATTRIBUTE_REFACTOR = "REFACTOR";
    
    public static final String EXTENDED_ATTRIBUTE_CASE_VALUE_TYPE = "CASE_VALUE_TYPE";
    
    public static final String EXTENDED_ATTRIBUTE_PARAM_TYPE = "PARAM_TYPE";
    
	/*----------------------------------����·�ɶ�Ӧ�ķ�֧��ֵ������------------------------------------*/
    public static final String CASE_OPTION_CASE_VALUE = "CASE_VALUE";

	public static final String CASE_OPTION_EXPRESS = "EXPRESS";
	
	public static final String DEFAULT_CASE_VALUE = "SYS_DEFAULT";
	
	public static final String DEFAULT_CASE_VALUE_NAME = "����";
	
	public static final String ORIGIN_LINE = "from_line";// �쳣���쳣��������
	public static final String ORIGIN_NODE = "from_node";// �ڵ��쳣��������
	
	// �쳣�����������ó���
	public static final String COMBOVALUE_SOMENODE = "ָ����ĳЩ�ڵ�";
	public static final String COMBOVALUE_ONENODE = "ָ����ĳһ�ڵ�";
	public static final String COMBOVALUE_ISAPPOINT_YES = "ָ��";
	public static final String COMBOVALUE_ISAPPOINT_NO = "δָ��";
	public static final String COMBOVALUE_REDO = "����";
	public static final String COMBOVALUE_REDOAFTERCANCEL = "����������";

	public static final String COMBOVALUE_PROC = "����";
	public static final String COMBOVALUE_WAIT = "�⿰����װ";
	public static final String COMBOVALUE_RETURN = "���˵�����ϵͳ";
	public static final String COMBOVALUE_BLOCK = "������ǰ����";

	public static final String SETOBJ_TITLE = "���ö���";
	
	/***************************�ʱ��Ȩ�ޱ�ʶ*******************************/
	
	public static final String PERMISSIONS_FLAG_YES = "Y";

	public static final String PERMISSIONS_FLAG_NO = "N";	
	
	// ʱ����
	public static final String LIMIT_ACTIVITY_VO="WfActivityLimit";
	public static final String LIMIT_NODE_VO="WfProcNodeLimit";
	public static final String LIMIT_NODE_INSTANCE_VO="WfProcNodeInstanceLimit";
	public static final String LIMIT_PROC_VO="WfProcLimit";
	public static final String LIMIT_PROC_INSTANCE_VO="WfProcInstanceLimit";
	
	
	public static final String LIMIT_AREA_TYPE = "��������";
	public static final String LIMIT_AREA = "�����ʾ";
	public static final String LIMIT_METRICUNIT = "������λ";
	public static final String LIMIT_METRICVALUE = "�澯ʱ��";
	public static final String LIMIT_HASTENVALUE = "�ߵ�ʱ��";
	public static final String LIMIT_PREVALUE = "Ԥ��ʱ��";
	public static final String LIMIT_EXPRESS = "�������ʽ";
	public static final String LIMIT_STATE = "״̬";
	public static final String LIMIT_REMARK = "��ע";
	
	public static final String OBJECT_TYPE_ACTIVITY = "0"; //WF_ACTIVITY_LIMIT.OBJECT_TYPE  0 �
	public static final String OBJECT_TYPE_ACTIVITY_REGION = "1"; //WF_ACTIVITY_LIMIT.OBJECT_TYPE 1 �����
	
	/*--------------------------------���̽�ģSEQ--------------------------*/
	
	public static final String WF_PROC_LIMIT_SEQ = "PROC_LIMIT_ID";
	public static final String WF_PROC_INST_LIMIT_SEQ = "WF_PROC_INST_LIMIT_ID";
	public static final String WF_ACTIVITY_LIMIT_SEQ = "ACTIVITY_LIMIT_ID";
	public static final String WF_PROC_NODE_INST_LIMIT_SEQ = "WF_PROC_NODE_INST_LIMIT_ID";
	public static final String WF_PROC_NODE_LIMIT_SEQ = "WF_PROC_NODE_LIMIT_ID";
	
	/*--------------------------------����ʱ�� --------------------------*/
	
	public static final String LIMIT_PROC = "����ʱ������";
	public static final String LIMIT_PROC_INSTANCE = "����ʵ��ʱ������";
	public static final String LIMIT_PROC_NODE = "�ڵ�ʱ������";
	public static final String LIMIT_ACTIVITY = "�ʱ������";
	public static final String LIMIT_NODE_INSTANCE = "�ڵ�ʵ��ʱ������";
	
	/*--------------------------------���̽�ģFlex --------------------------------����------------------*/
	
	//added by yangkai 2009-8-24
	public static final String INTER_SERVICE_ORDERS_ID_SEQ = "INTER_SERVICE_ORDERS_ID";// �������񶨵��ӿڱ�����
	public static final String PWD_FLAG = "N";//�����㷨ѡ�������N��ʹ��MD5�㷨������Ϊ�����ṩ���㷨
	
	//add by shilei 2009-9-4
	/*--------------------------------У�����----------------------------------------*/
	public static final String PARSE_CONFIG_CONFIG_TYPE_BASIC = "0";// ��������
	
	public static final String PARSE_CONFIG_CONFIG_TYPE = "1";// �ǻ�������
	
	public static final String CHK_RULE_OPEN_FLAG_OPEN = "O";// ����

	public static final String CHK_RULE_OPEN_FLAG_CLOSE = "C";// ����
	
	public static final String CHK_RULE_BASE_FLAG_YES = "Y";// ����У��

	public static final String CHK_RULE_BASE_FLAG_NO = "N";// �ǻ���У��
	
	public static final String CHK_RULE_RESULT_SUCCESS = "0";// У��ɹ�

	public static final String CHK_RULE_RESULT_FAILED = "1";// У��ʧ��
	
	public static final String MATCH_FACTOR_SO_CHECK = "1";// �������ƥ�����أ�����ҵ��
	
	public static final String PARSE_CONFIG_XML_PATH = "XML_PATH";// Properties-key

	public static final String SERVICE_ORDER_DOCUMENT = "SERVICE_ORDER_DOCUMENT";// Properties-key
	
	public static final String CHK_RULE_FACTOR_TYPE = "FACTOR_TYPE";// Properties-key
	
	public static final String BASE_CHK_RULE_PROD_MAP = "PROD_MAP";// Properties-key
	
	public static final String BASE_CHK_RULE_CHG_SERV_SPEC_MAP = "CHG_SERV_SPEC_MAP";// Properties-key
	
	public static final String BASE_CHK_RULE_BUSINESS_MAP = "BUSINESS_MAP";// Properties-key
	
	public static final String SRC_PARAM_XML = "SRC_PARAM_XML"; //Properties-key
	
	public static final String FOR_SCENE_SA_CHECK = "SA_CHECK"; //���ϵ�У��
		
	public static final String FOR_SCENE_SO_CHECK = "SO_CHECK";// ����У��

	public static final String FOR_SCENE_RS_ASSIGN = "RS_ASSIGN";// ��Դ����

	public static final String FOR_SCENE_RS_QUERY = "RS_QUERY";// ��Դ��ѯ
	
	public static final String MATCH_FACTOR_BASIC = "0";// ������ƥ������
	
	public static final String MATCH_FACTOR = "1";
	
	public static final String BUSI_RULE_CALL_TYPE_JAVA_CLASS = "J";// Java Class

	public static final String BUSI_RULE_CALL_TYPE_PROCEDURE = "P";// �洢����

	public static final String BUSI_RULE_CALL_TYPE_SQL = "S";// ��̬SQL
	
	public static final String PARAMETER_SEPARATOR = "/";// �����ָ���
	
	public static final String LIST_CHK_RULE_BASIC = "0";// ����У��

	public static final String LIST_CHK_RULE_UN_RELA = "1";// ȫ��У��

	public static final String LIST_CHK_RULE_RELA = "2";// ����У��
	
	public static final String CACHE_MAP_KEY_BUSINESS = "1";// ����Keyֵ����

	public static final String CACHE_MAP_KEY_BUSI_RULE = "2";// ����Keyֵ����

	public static final String CACHE_MAP_KEY_CHK_RULE = "3";// ����Keyֵ����

	public static final String CACHE_MAP_KEY_PARSE_CONFIG = "4";// ����Keyֵ����
	
	public static final String CACHE_MAP_KEY_PROD = "5";// ����Keyֵ����
	
	public static final String CACHE_MAP_KEY_CHG_SERV_SPEC = "6";// ����Keyֵ����

	public static final String FACTOR_TYPE_PROD = "P";// ����ƥ�䣨��Ʒ��

	public static final String FACTOR_TYPE_CHG_SERV_SPEC = "C";// ����ƥ�䣨�ͻ�����

	public static final String FACTOR_TYPE_BUSINESS = "B";// ����ƥ�䣨����ҵ��

	public static final String FACTOR_TYPE_BASIC = "0";// ����ƥ�䣨����У�飩
	
	public static final String CHK_RULE_PLACEHOLDER = "PLACEHOLDER";// ռλ��
	
	public static final String XML_PATH_FOR_CHG_SERV_SPEC= "//SoInfo/ChgServSpecId"; // �ͻ�������serviceOrder�е�λ�ã����ͻ������XML_PATHֵ
	
	public static final String SYS_CONFIG_IS_CHECK_MOD_CHG_SERV_SPEC_IDS= "110014"; // ������ͻ��������(�Զ��Ÿ������ַ���)
	
	public static final String STRING_FOR_PROD_INFO= "ProdInfo"; // �ַ���
	
	public static final String STRING_FOR_FROM_PROD_INFO= "FromProdInfo"; // �ַ���
	
	/********************************************	SAS START	*****************************************/
	
	public static final String SYS_CONFIG_DEFAULT_PROD_CAT_ID = "215005";
	
	public static final String SYS_CONFIG_AUTO_VOICE_OVERTIME_ID = "215008"; //�Զ�������ʱ���ʱ��(��λ����)
	
	public static final String SYS_CONFIG_FIRST_QUERY_RMS_ID = "215010";//���������ѯCRM��RMS˳�򿪹�,Y���Ȳ�ѯRMS��N�Ȳ�ѯCRM
	
	public static final String FAULT_TYPE_ID = "10000";
	
	public static final String FAULT_CAT_GENERAL = "G";//��ͨ�ϰ�
	
	public static final String FAULT_CAT_PUBLIC = "P";//�����ϰ�
	
	public static final String FAULT_CAT_BATH = "S";//������ϰ�
	
	public static final String FAULT_RELATION_GS = "GS";//��ͨ�ϰ�������������ϰ�
	
	public static final String FAULT_RELATION_GG = "GG";//��ͨ�ϰ���������ͨ�ϰ�
	
	public static final String FAULT_RELATION_GP = "GP";//��ͨ�ϰ������������ϰ�
	
	public static final String FAULT_APPLY_CHG_SERV_SPEC_ID = "2000000";//������Ĭ�Ͽͻ�����
	
	public static final String MANSEND_CHG_SERV_SPEC_ID = "2000100";//�������˹��ɵ��ͻ�����
	
	public static final String HANDLE_TYPE_CONTINUE = "C";//���Ϲ�����ϵ����ʽ
	
	public static final String FAULT_HANDLE_TYPE_DESIGN = "design";//���Ϸ�����ʽ:���
	
	public static final String FAULT_HANDLE_TYPE_RELATE = "relate";//���Ϸ�����ʽ:����
	
	public static final String STEP_ID_FAULT_APPLY = "SG2000";//������������Ӧ���̻���
	
	public static final String STEP_ID_FAULT_RELATE = "SG2010";//���Ϲ�������
	
	public static final String STEP_ID_FAULT_DESIGN = "SG2002";//���Ϸ������
	
	public static final String MOST_ACC_NBR = "0";//������ϰ�����ҵ�����
	
	public static final String SYS_CONFIG_WSURL_112 = "110005"; // sys_config
	
	// ��������
	public static final String SO_SO_CAT_SPS = "1"; // 1 Ӫҵ�����࿪ͨ

	public static final String SO_SO_CAT_SGS = "2"; // 2 ��������
	
	public static final String SO_WORK_AREA_Id= "470101"; //����ϵͳ������ϰ����⹤��ID
	
	public static final String SO_WORK_AREA_NAME= "���ɹ�������"; //����ϵͳ������ϰ����⹤������
	
	// seq
	public static final String SEQ_SO_FAULT_ID = "SO_FAULT_ID"; // ����������Ϣ������
	
	public static final String SO_FAULT_COMPLAINT_ID_SEQ = "SO_FAULT_COMPLAINT_ID";//������Ͷ�߼�¼������
	
	public static final String SO_FAULT_RESULT_ID_SEQ = "SO_FAULT_RESULT_ID";//�ϰ����޽�������ӿڱ�����

	public static final String SEQ_SO_ACC_NBR_ID = "SO_ACC_NBR_ID"; // ����ҵ����������
	
	public static final String HANDLE_TYPE_FAULT_APPLY_INFO = "��������";   //��������
	
	public static final String HANDLE_TYPE_RE_APPLY_INFO = "�ظ����";       //�ظ����
	
	public static final String HANDLE_TYPE_MODIFY_INFO = "���ϱ��";       //���ϱ��
	
	public static final String HANDLE_TYPE_FAULT_APPLY = "600000";   //��������
	
	public static final String HANDLE_TYPE_RE_APPLY = "600002";       //�ظ����
	
	public static final String HANDLE_TYPE_MODIFY = "600003";       //���ϱ��
	
	public static final String HANDLE_TYPE_DIRECT_ARC = "600001";     //ֱ�ӹ鵵

	
	public static final String HANDLE_TYPE_LINE_TEST = "600000"; //��·����
	public static final String HANDLE_TYPE_PORT_RESET = "600001"; //�˿ڸ�λ
	public static final String HANDLE_TYPE_PORT_QUERY = "600002"; //�˿ڲ���
	
	public static final String FAULT_PHENOM_ID_SEQ = "FAULT_PHENOM_ID";// ������������
	
	public static final String FAULT_NBR_CLASS = "1";// ����ȼ�

	public static final String FAULT_LEVEL_ID_SEQ = "FAULT_LEVEL_ID";// ���ϵȼ�����

	public static final String FAULT_PREHANDLE_WAY_ID_SEQ = "FAULT_PREHANDLE_WAY_ID";// ��������Ԥ��������
	
	public static final String FAULT_RELATION_ID_SEQ = "FAULT_RELATION_ID";//���Ϲ�����ϵ����
	
	public static final String SO_FAULT_EXT_ID_SEQ = "SO_FAULT_EXT_ID";	//���ϴ�����Ϣ����
	
	/* ����ԭ��� */
	public static final String FAULT_REASON_ID_SEQ = "FAULT_REASON_ID";// ����ֵ
	
	/* STEP_SPEC_PRPTY�� */
	public static final String SO_PRPTY = "SO_PRPTY";// COMPONENT_CODEֵ
	
	/* ����������ԭ���ϵ�� */
	public static final String FAULT_REASON_TO_TYPE_ID_SEQ = "FAULT_REASON_TO_TYPE_ID";// ����ֵ
	
	public static final String LOG_SG_SUBSYSTEM = "SG"; // SG��ϵͳ��ʶ
	/********************************************	SAS END	*****************************************/

	public static final String BUTTON_TYPE = "B";//�������ΪButton
	
	public static final String COMPONENT_TYPE_IFRAME = "I";//�������Ϊiframe
	
	public static final String COMPONENT_TYPE_PIECE = "P";//��Ӧ���ڿؼ�
	
	public static final String SO_PROC_CHK_CONFIG_ID = "34110";//�Ƿ���ô洢���̽��ж�������У�鿪��

	
	public static final String SYS_CONFIG_GROUP_SPEC="110011";//��Դ���÷��ض���ӳ��Ϊ�¾�ֵ��Ⱥ�����б�
	
	public static final String CHANGED_FLAG="Y";//���ڱ�ʶ��ʩ���������Ƿ�Ը����Խ����˱����
	//�������Ϣһ����Ҫ����CRM�����������µļ�¼����ԭ��¼���Ϊ���ϡ�Y �б�� 	N δ���

	/******************************************** SA *****************************************/
	public static final String SA_QUERY = "SA_QUERY";		//ghϵͳ�еı��ϵ���ѯҳ���־
	public static final String SA_CHANGE = "SA_CHANGE"; //ghϵͳ�еı��ϵ����ҳ���־
	public static final String SA_CANCEL = "SA_CANCEL"; //ghϵͳ�еı��ϵ�����ҳ���־
	public static final String SA_AUDIT = "SA_AUDIT"; //ghϵͳ�еı��ϵ����ҳ���־ 
	public static final String SA_RELATE = "SA_RELATE"; //ghϵͳ�еı��ϵ�����ҳ���־

	public static final String WO_GUI_SCENE_WO_HANDLE = "WO_HANDLE";//ʩ����������
	public static final String WO_GUI_SCENE_SO_DISPLAY = "SO_DISPLAY";//������ϸ��Ϣչ�֣�
	public static final String WO_GUI_SCENE_WO_RESPONSE = "WO_RESPONSE";//������Ӧ����
	
	public static final String REF_FLAG_Y = "Y"; 	//��������� ���͹���
	public static final String REF_FLAG_N = "N";	//��������� ��ͨ����
	
	public static final String SA_FAULT_DETERMINE_STEP = "SP3059"; //���ϵ�ʩ������ ���϶��Ի���
	
	public static final String SA_FAULT_DETERMINE = "SA_FAULT_DETERMINE";	//���ϵ�ʩ������ ���϶���
	
	public static final String SA_FAULT_HANDLE_RATE = "SA_FAULT_HANDLE_RATE"; //���ϵ�ʩ������ �������
	
	public static final String SA_FAULT_SUCCESS_RETURN = "SA_FAULT_SUCCESS_RETURN"; //���ϵ�ʩ������ ������
	
	public static final String SA_FAULT_HANDLE_WORK_TYPE = "137";	//��������Ϊ���ϴ���
	public static final String SA_FAULT_APPLY_WORK_TYPE = "390";	//��������Ϊ��������
	public static final String SA_FAULT_CONFIRM_WORK_TYPE = "315";	//��������Ϊ����֤ʵ modify by Baixd 315-->390
	public static final String SA_FAULT_CONFIRM_FAIL_REASON_PROC = "IVR.GET_FAIL_REASON4SO";	//��������Ϊ����֤ʵ
	public static final String SA_FAULT_CONFIRM_FAIL_REASON_4040220 = "4040220";	//�쳣ԭ���˻ع��Ϸ���
	
	public static final String SA_FAULT_RES_CHANGE_CONFIG_ID = "215001"; //���ϵ�ʩ��������Դ����Ƿ�����Դ��ͨ CONFIG_ID=215001 
	public static final String SA_FAULT_RES_CHANGE_Y = "Y"; //���ϵ�ʩ��������Դ�����־ ��
	public static final String SA_FAULT_RES_CHANGE_N = "N"; //���ϵ�ʩ��������Դ�����־ ��
	public static final String SA_FAULT_RES_CHANGE = "RES_CHANGE_Y";//��Դ���

	public static final String SA_FAULT_CONFIRM_STEP = "SP3058"; //����֤ʵ����
	public static final String SA_FAULT_CONFIRM_Y = "SA_FAULT_CONFIRM_Y";//����֤ʵͨ��
	public static final String SA_FAULT_CONFIRM_N = "SA_FAULT_CONFIRM_N";//����֤ʵʧ��
	
	public static final String HANDLE_RATE_FEEDBACK = "401010"; //�������ȷ���
	
	public static final String MAX_MSG_CALL_COUNT = "34200";// ��������ʧ������������
	
	public static final String SA_FAULT_TEST_RESULT_SUCCESS = "SUCCESS"; //���ϲ��Գɹ�
	public static final String SA_FAULT_TEST_RESULT_FAIL = "FAIL"; //���ϲ���ʧ��
	public static final String SA_FAULT_TEST_RESULT_CODE = "T"; //���ϲ��Խ������ 
	
	public static final String SA_FAULT_TEST_RESULT_STEP_A = "SG2012"; //���ϲ��Ի��� �Զ�����
	public static final String SA_FAULT_TEST_RESULT_STEP_M = "SG2001"; //���ϲ��Ի��� �˹�����
	
	public static final String CHG_SERV_SPEC_FOR_SHARE_LINE_NBR = "22001";// �ͻ�������루�������ߺ��룩

	public static final String PROD_FOR_SHARE_LINE_NBR = "22000";// ��Ʒ���루�������ߺ��룩
	
	public static final String GROUP_SPEC_FOR_SHARE_LINE_NBR = "22002";// Ⱥ�����ͣ��������ߺ��룩
	public static final String COMPL_FLAG_Y = "Y";//ͬȺ���ͬCO���޻�δ������������Ա
	public static final String COMPL_FLAG_N = "N";//ͬȺ���ͬCO���л�δ������������Ա
	
	public static final String REQ_RES_SYSTEM_QUERY_TYPE = "S"; //����ϵͳ��ѯ��Դϵͳ��ѯ����S������ʵ��ID
	public static final String APPLICATION_SYSTEM_SAS = "SAS"; // ��Դ��ѯӦ�ã�������ϵͳ
	
	public static final String SA_SENDER_TYPE = "S";
	
	public static final String CONFIRM_STYLE_MAN="M" ; //�˹�֤ʵ
	public static final String CONFIRM_RESULT_PASS="Y"; //����֤ʵͨ��
	public static final String CONFIRM_RESULT_FAIL="N"; //����֤ʵͨ��
	
	public static final String LIMITTD_QUERY_RECORD="110019" ; //��������ѯ�����Ŀ���
	
	/**SAS����CRM��س���**/
	public static final String EID_CRM_SAS_QRY_CUST_REQ = "SAS_QRY_CUST_REQ"; // CRM�ӿڱ���
	public static final String XMLHEADER_SERIALNO_FOR_CRM_SEQ = "XMLHEADER_SERIALNO_FOR_CRM"; // CRM�ӿڲ�������
	public static final String CRM_SECURITY_PRINCIPAL = "weblogic"; // CRM��֤�û�
	public static final String CRM_SECURITY_CREDENTIALS = "weblogic"; // CRM��֤����
	public static final String SENDER_FOR_SAS_TO_CRM = "SAS";

	/* ��ѯ�����ؼ��� */
	public static final String KEY_FOR_QRY_CRM_ACC_NBR = "ACC_NBR";// ACC_NBR��ҵ�����
	public static final String KEY_FOR_QRY_CRM_ACCOUNT = "ACCOUNT";// ACCOUNT���˺�
	public static final String KEY_FOR_QRY_CRM_CUST_ID = "CUST_ID";// CUST_ID���ͻ���ʶ
	public static final String KEY_FOR_QRY_CRM_SERV_ID = "SERV_ID";// SERV_ID������ʵ��
	public static final String KEY_FOR_QRY_CRM_PROD_CAT = "PROD_CAT";// PROD_CAT�����𣬲�Ʒ���
	public static final String KEY_FOR_QRY_CRM_LOCAL_NET = "LOCAL_NET";// LOCAL_NET��������
	public static final String KEY_FOR_QRY_CS_SA_NBR = "SA_NBR"; //SA_NBR���ⲿ������
	public static final String KEY_FOR_QRY_CS_SHARE_LINE_NBR = "SHARE_LINE_NBR"; //SHARE_LINE_NBR�����ߺ���

	/* ��ѯ�������� */
	public static final String DATE_TYPE_FOR_QRY_CRM_N = "N"; // Number
	public static final String DATE_TYPE_FOR_QRY_CRM_C = "C"; // Char
	public static final String DATE_TYPE_FOR_QRY_CRM_D = "D"; // Date

	/* ��ѯ����ƥ������ */
	public static final String MATCH_TYPE_FOR_QRY_CRM_E = "E"; // E
																// EQUAL����ȷƥ�䣬���
	public static final String MATCH_TYPE_FOR_QRY_CRM_I = "I"; // I
																// IN����Ӧ���VALUE
	public static final String MATCH_TYPE_FOR_QRY_CRM_L = "L"; // L
																// LIKE��ģ��ƥ�䣬����
	public static final String MATCH_TYPE_FOR_QRY_CRM_B = "B"; // B
																// BETWEEN����Χ�޶�
	
	/*��ѯ����Ľڵ�����*/
	public static final String RESULT_NODE_FOR_QRY_CRM_CUSTBASE = "CustBaseInfo"; // �ͻ�������Ϣ
	public static final String RESULT_NODE_FOR_QRY_CRM_PROD_INFO = "ProdInfos"; // ��Ʒ��Ϣ
	public static final String RESULT_NODE_FOR_QRY_CRM_MAIN_PROD = "MainProdInfo"; // ����Ʒ��Ϣ
	public static final String RESULT_NODE_FOR_QRY_CRM_SUB_PROD = "SubProdInfos"; // ������Ʒ��Ϣ
	public static final String RESULT_NODE_FOR_QRY_CRM_ADDR = "AddrInfos"; // ��ַ��Ϣ
	public static final String RESULT_NODE_FOR_QRY_CRM_ACC_NBR = "AccNbrInfos"; // ������Ϣ
	public static final String RESULT_NODE_FOR_QRY_CRM_SLA = "SLAInfos"; // SLA��Ϣ
	
	public static final String NOTIFY_TYPE_SM = "4"; // ֪ͨ����
	public static final String NOTIFY_CONFIG_ID = "0"; // ֪ͨ����notifyConfigId
	public static final String NOTIFY_TYPE_WO = "0"; // ֪ͨ���� ���ɹ���

	public static final String IS_SO_ARC = "34100"; // �����鵵
	public static final String IS_SO_ARC_Y = "Y";
	public static final String IS_SO_ARC_N = "N";

	public static final String HANDLE_TYPE_WO_PRESS = "600001";
	public static final String HANDLE_TYPE_WO_PRESS_INFO = "�����߰�";
	public static final String HANDLE_TYPE_WO_SUCCESS_PRESS = "�ɹ��ߵ�";
	
	public static final String HANDLE_MSG_WO_PRESS = "600002";
	
	public static final String HANDLE_TYPE_CS_URGE = "600020";
	public static final String HANDLE_TYPE_CS_URGE_INFO = "�ͷ�ϵͳ�ϰ�����";
	
	public static final String HANDLE_TYPE_NOTIFY_CS = "600021";//�׶�֪ͨ�ͷ�ϵͳ
	
	public static final String HANDLE_TYPE_SA_REAPPLY = "501010";
	public static final String HANDLE_TYPE_SA_REAPPLY_INFO = "�ظ����";
	public static final String HANDLE_TYPE_SA_TEST = "501020";
	public static final String HANDLE_TYPE_SA_TEST_INFO = "���ϲ���";
	public static final String HANDLE_TYPE_SA_PREHANDLE = "501030";
	public static final String HANDLE_TYPE_SA_PREHANDLE_INFO = "����Ԥ����";
	public static final String HANDLE_TYPE_SA_REPORT = "501040";
	public static final String HANDLE_TYPE_SA_REPORT_INFO = "�����ϱ�";
	public static final String HANDLE_TYPE_SA_RELATE = "501050";
	public static final String HANDLE_TYPE_SA_RELATE_INFO = "���������ϰ�";
	public static final String HANDLE_TYPE_SA_RELATE_P = "501060";
	public static final String HANDLE_TYPE_SA_RELATE_P_INFO = "���������ϰ�";
	public static final String HANDLE_TYPE_SA_RELATE_S = "501070";
	public static final String HANDLE_TYPE_SA_RELATE_S_INFO = "����������ϰ�";
	public static final String HANDLE_TYPE_SA_IDENTIFY = "501080";
	public static final String HANDLE_TYPE_SA_IDENTIFY_INFO = "ʶ�������ϰ�";
	public static final String HANDLE_TYPE_SA_RELEASE = "501090";
	public static final String HANDLE_TYPE_SA_RELEASE_INFO = "����ϰ�����";
	public static final String USER_FAULT_TYPE_NAME="�û����ϰ�";
	public static final String HANDLE_TYPE_SA_ARCHIVE = "501095";
	public static final String HANDLE_TYPE_SA_ARCHIVE_INFO="��浥ֱ�ӹ鵵";
	public static final String HANDLE_TYPE_SA_ANALYSIS = "400041";
	public static final String HANDLE_TYPE_SA_ANALYSIS_INFO="�����Զ�����";
	public static final String HANDLE_TYPE_SA_MODIFY = "501096";
	public static final String HANDLE_TYPE_SA_MODIFY_INFO = "�ϰ����ĵ�";
	
	
	public static final String SYS_CONFIG_WSURL_SAS_CRM = "215002"; //CRM�ṩ��SASϵͳ webService��ַ
	
	public static final String SAS2CrmService = "Crm4SasService"; //CRM�ṩ��SASϵͳ��webService����
	
	public static final String PROD_CAT_TYPE_C = "1";  //���𣬲�Ʒ��� ����
	public static final String PROD_CAT_TYPE_G = "0";  //���𣬲�Ʒ��� G��
	
	public static final String STEP_ID_FAULT_ANALYSIS = "SG2008"; // ���Ϸ�������

	public static final String SURVEY_RESULT_ID_SEQ = "SURVEY_RESULT_ID";// �طý��

	public static final String SURVEY_RESULT_DETAIL_ID_SEQ = "SURVEY_RESULT_DETAIL_ID";// �طý����ϸ

	public static final String SURVEY_MATCH_ID_SEQ = "SURVEY_MATCH_ID";// �ط�ƥ��

	public static final String SURVEY_TEMPLATE_ID_SEQ = "SURVEY_TEMPLATE_ID";// �ط�ģ��

	public static final String SURVEY_ITEM_ID_SEQ = "SURVEY_ITEM_ID";//�ط�Ԫ��
	
	public static final String AUTO_VOICE_QUEUE_ID_SEQ = "AUTO_VOICE_QUEUE_ID";
	
	public static final String AUTO_VOICE_QUEUE_BUSI_TYPE_SP = "SP";//����ͨҵ��
	public static final String AUTO_VOICE_QUEUE_BUSI_TYPE_SA = "SA";//������ҵ��

	public static final String AUTO_VOICE_QUEUE_EVENT_TYPE_C = "C";//����֤ʵ
	public static final String AUTO_VOICE_QUEUE_EVENT_TYPE_V = "V";//�ͻ��ط�
	
	public static final String SO_FAULT_REPORT_FLAG_YES = "Y";//������:�����ϱ�
	public static final String SO_FAULT_REPORT_FLAG_NO = "N";//������:���ϱ�
	
	public static final String SO_FAULT_NOTIFY_FLAG_YES = "Y";//������:֪ͨ
	public static final String SO_FAULT_NOTIFY_FLAG_NO = "N";//������:��֪ͨ
	
	public static final String SO_FAULT_STS_WAIT ="A,D,E,M,W,t";//�ϰ�����״̬���ȴ�����
	public static final String SO_FAULT_STS_PRC="B,F,g,h,I,K,P,s,T,U,V,Y";//�ϰ�����״̬�����ڴ���
	public static final String SO_FAULT_STS_COM="C,S";//�ϰ�����״̬���������
	
	public static final String FAULT_OBJECT_TYPE_AREA = "AREA";//������:���϶�������(Ӱ�췶Χ) ������
	public static final String FAULT_OBJECT_TYPE_EXCH = "EXCH";//������:���϶�������(Ӱ�췶Χ) ����
	public static final String FAULT_OBJECT_TYPE_MDF = "MDF";//������:���϶�������(Ӱ�췶Χ) ���߼�
	public static final String FAULT_OBJECT_TYPE_CCP = "CCP";//������:���϶�������(Ӱ�췶Χ) ������
	
	public static final String FAULT_OBJECT_TYPE_ACC_NBR = "ACC_NBR";//������:���϶�������(Ӱ�췶Χ)
	//���뷶Χ
	public static final String FAULT_RULE_TYPE_I = "I";// �ϰ��������ͣ����ع���
	public static final String FAULT_RULE_TYPE_R = "R";// �ϰ��������ͣ�ʶ�����
	public static final String AUTO_VOICE_QUEUE_STS_D = "D";//�ȴ�����
	public static final String AUTO_VOICE_QUEUE_STS_P = "P";//����������ȡ���ݣ����ڴ���
	public static final String AUTO_VOICE_QUEUE_STS_E = "E";//���������쳣����绰���˽����ȣ���ת�˹�ʩ������
	public static final String AUTO_VOICE_QUEUE_STS_F = "F";//��������ʧ�ܣ�����гɹ��ص���
	public static final String AUTO_VOICE_QUEUE_STS_C = "C";//��������ɹ��������ʧ�ܻص�
	public static final String AUTO_VOICE_QUEUE_STS_R = "R";//����
	public static final String AUTO_VOICE_QUEUE_M = "M";// �˹�ʩ��
	
	public static final String AUTO_VOICE_QUEUE_STSFLAG_CEF = "CEF"; //��������ص��ɹ���ʧ�ܱ�־
	public static final String AUTO_VOICE_QUEUE_STSFLAG_P = "P"; //���������쳣��־
	
	public static final String AUTO_VOICE_QUEUE_BACKFILL_FLAG_F = "F"; //��������ص�ʧ�ܻ�����־
	public static final String AUTO_VOICE_QUEUE_BACKFILL_FLAG_Y = "Y"; //��������ص��ɹ�������־
	
	public static final String SO_FAULT_COMPLAINT_STS_UNCOMP = "N"; //δͶ��
	public static final String SO_FAULT_COMPLAINT_STS_UNPRESS = "D"; //��Ͷ�ߴ�����
	public static final String SO_FAULT_COMPLAINT_STS_PRESS = "C"; //��ɴ���

	/*Ѳ��ƻ�  �Ե� 2010-3-4 */
	public static final String SYS_CONFIG_WORK_TYPE_ID = "110022";//��·Ѳ�칤�����ͱ�ʶ����
	
		
	public static final String EXEC_CYCLE_TEMP = "C";//ִ������Ϊ��ʱ
	public static final String EXEC_CYCLE_DAY = "D";//ִ������Ϊ��
	public static final String EXEC_CYCLE_WEEK = "W";//ִ������Ϊ��
	public static final String EXEC_CYCLE_MONTH = "M";//ִ������Ϊ��
	public static final String EXEC_CYCLE_YEAR = "Y";//ִ������Ϊ��
	public static final String EXEC_CYCLE_ALL = "A";//���������Լƻ�
	
	public static final String EXEC_DATA_DEFAULT = "0";//ִ���꣬�£��ܣ���Ĭ��ֵΪ0
	public static final String PLAN_TYPE_ONCE = "O";//�ƻ�����Ϊһ���Լƻ�
	public static final String PLAN_TYPE_CYCLE = "C";//�ƻ�����Ϊ�����Լƻ�
	/* */
	public static final String DISABLE_RETURN_USERS = "215020";//�����ϣ�������ص�������ʩ����Ա�б�

	public static final String PROD_CAT_ID_ADSL = "40"; //������ҵ��
	
	/*--------------------�쵥����-----------------------*/
	public static final String OVER_FETCH_YES = "Y";// �쵥����

	public static final String OVER_FETCH_NO = "N";// �����쵥
	public static final String MSG_TYPE_RP = "RP";// ������������Ϣ����
	
	
	public static final String SYS_CONFIG_BOOKDAY_ID="31100";//ԤԼ������ѯ����ԤԼʱ���ѯ��Χ
	public static final String INSTALL_WORK_TYPE_ID="7";//װ����������
	/*------------------------------DOM�ӿڲ���(paraMap)keyֵ����-----------------------------*/

	public static final String PARA_MAP_SO_SVO = "SoSVO";

	public static final String PARA_MAP_SERVICE_ORDER_ID = "serviceOrderId";
	
	public static final String PARA_MAP_INTER_SERVICE_ORDER_SVO = "InterServiceOrderSVO";

	public static final String PARA_MAP_INTER_SERVICE_ORDERS_SVO = "InterServiceOrdersSVO";

	public static final String PARA_MAP_INTER_MSG_CENTER_SVO = "InterMsgCenterSVO";

	public static final String PARA_MAP_SO_MSG_CENTER_SVO = "SoMsgCenterSVO";

	public static final String PARA_MAP_INTER_SO_EXCEPTION_SVO = "InterSoExceptionSVO";

	public static final String PARA_MAP_SCHEMA_SERVICE_ORDER = "ServiceOrder";

	public static final String PARA_MAP_SCHEMA_SERVICE_ORDERS = "ServiceOrders";

	public static final String PARA_MAP_SCHEMA_EXPT_SERVICE_ORDER = "ExptServiceOrder";

	public static final String PARA_MAP_SCHEMA_SERVICE_ORDER_RETURN = "ServiceOrderReturn";

	public static final String PARA_MAP_SCHEMA_CUST_ORDER = "CustOrder";

	public static final String PARA_MAP_SCHEMA_RESULT_INFO = "ResultInfo";

	public static final String PARA_MAP_EXT_SO_NBR = "extSoNbr";// ���񶨵�����

	public static final String PARA_MAP_CO_NBR = "coNbr";// �ͻ���������

	public static final String PARA_MAP_SO_NBR = "soNbr";// ��������

	public static final String PARA_MAP_WO_NBR = "woNbr";// ��������

	public static final String PARA_MAP_SPEC_PRPTY_LIST = "specPrptyList";// ��������б�

	public static final String PARA_MAP_INPUT_FLAG_LIST = "inputFlagList";// ������Ϣ��ʽ�б�

	public static final String PARA_MAP_SPEC_PRPTY_VALUE_LIST = "specPrptyValueList";// �������ֵ�б�

	public static final String PARA_MAP_PROD_INST_ID = "prodInstId";// ����ʵ������

	public static final String PARA_MAP_CO_NBR_LIST = "coNbrList";// �ͻ����������б�

	public static final String PARA_MAP_ORDER_TYPE = "orderType";// �ͻ���������

	public static final String PARA_MAP_ORDER_TYPE_A = "A";// �ͻ���������:��װ

	public static final String PARA_MAP_ORDER_TYPE_M = "M";// �ͻ���������:�ĵ�

	public static final String PARA_MAP_ORDER_TYPE_B = "B";// �ͻ���������:���ɲ�����

	public static final String PARA_MAP_ACT_TYPE = "actType";// ��������

	public static final String PARA_MAP_RECIEVE_DATE = "receiveDate";// �ͻ���������ʱ��

	public static final String PARA_MAP_PROD_ID_STR = "prodIdStr";// ��Ʒ���
																	// �Զ��ŷָ�

	public static final String PARA_MAP_PROD_ID = "prodId";// ��ƷID

	public static final String PARA_MAP_LOCAL_NET_ID = "localNetId";// ������

	public static final String PARA_MAP_EXT_WO_NBR = "extWoNbr";// �ⲿ������

	public static final String PARA_MAP_SCHEMA_QRY_WOS_OF_SO = "QryWosOfSo";

	public static final String PARA_MAP_BOOK_DATE_TIME = "bookDateTime";// ԤԼʱ��

	public static final String PARA_MAP_COMP_DATE_TIME = "compDateTime";// ����ʱ��

	public static final String PARA_MAP_SERV_INST_ID = "servInstId";// ����ʵ��ID

	public static final String PARA_MAP_EXCH_ID = "exchId";// ����ID

	public static final String PARA_MAP_AREA_ID = "areaId";// ����ID

	public static final String PARA_MAP_CHG_SERV_SPEC_ID = "chgServSpecId";// �ͻ�����ID

	public static final String PARA_MAP_WORK_AREA_ID = "workAreaId";// ����ID

	public static final String PARA_MAP_STAFF_ID = "staffId";// Ա��ID
	
	public static final String PARA_MAP_STAFF_NAME = "staffName";// Ա������

	public static final String PARA_MAP_RETURN_STR = "retStr";// ����ֵ

	public static final String PARA_MAP_RETURN_LIST = "retList";// �����б�

	public static final String PARA_MAP_SCHEMA_SO_SI_GROUP_CHANGE_ASK = "SoSiGroupChangeAsk";

	public static final String PARA_MAP_RESULT_CODE = "resultCode"; // �ӿڷ���ֵ

	public static final String PARA_MAP_RESULT_INFO = "resultInfo"; // �ӿڷ�����Ϣ

	public static final String PARA_MAP_SCHEMA_RES_RESULT = "result"; // �ӿڷ���Э��

	public static final String PARA_MAP_WO_SVO = "WoSVO";

	public static final String PARA_MAP_CONTROL_INFO_TYPE = "ControlInfoType";

	public static final String PARA_MAP_RES_SERV_INFO_TYPE = "ResServInfoType";

	public static final String PARA_MAP_OPER_FALG = "operFlag";

	public static final String PARA_MAP_NO_FLAG = "noFlag";

	public static final String PARA_MAP_RUN_STS = "runSts";

	public static final String PARA_MAP_IS_SELF = "isSelf";

	public static final String PARA_MAP_RESOURCE_ARCHIVE_REQUEST = "ResourceArchiveRequest";

	public static final String PARA_MAP_SO_PRIORITY_LIST = "soPriorityList";// �������ȼ��б�

	public static final String PARA_MAP_XML_TYPE = "xmlType";

	public static final String PARA_MAP_XML = "xml";
	
	public static final String PARA_MAP_BACK_FILL_LIST = "backFillList";

	public static final String PARA_MAP_BACK_FILL_INFO = "backFillInfo";

	public static final String PARA_MAP_BACK_FILL_ID = "backFillId";
	
	public static final String PARA_MAP_BACK_FILL_OBJ = "backfillObj";
	public static final String SYNC_MAINT_AREA_TO_RMS = "35010"; // �Ƿ�����Դͬ��ά��������
	public static final String SYNC_MAINT_AREA_TO_RMS_Y = "Y"; // ����Դͬ��ά��������
	public static final String SYNC_MAINT_AREA_RESULT_CODE = "0";//����Դϵͳͬ������ʱ��Դ����ֵ
	
	public static final String SYS_CONFIG_IS_QUERY_HIS = "215021";// ��crm��򿪹����б�ʱ���Ƿ���Ҫ������ʷ����в�ѯ
	
	//2010-8 lilin start
	public static final String DELIVER_FLAG_YES = "Y";
	public static final String DELIVER_FLAG_NO = "N";

	//2010-8 lilin end
    //��Դ��� add by liyaquan
	public static final String MSG_ORDER_ZYBG = "ZYBG";//��Դ���
	public static final String MOBILE_ZYBG = "ZSZYBG";//������ά��Դ���
	public static final String EID_RES_CHG_RES_PRPTY = "USED_RES_CHANGE_REQ"; //��Դ�������
	public static final String FUNCODE_RES_CHANGE_REQUEST = "resChangeRequest"; //��Դ���
	public static final String HANDLE_TYPE_CHG_RES_PRPTY = "400700"; //�����޸���Դ
	public static final String SO_STS_P = "P";
	/*������Դ�����־*/
    public static final String WO_RES_CHANG_FALG = "Y";
    public static final String SYS_CONFIG_WO_HANLDE_QUERY_LOG = "215038";//ʩ�������ѯ������־�Ƿ��¼����
	
    
    /*********************�ƶ�ƽ̨��***************************************/
    public static final String SYS_NAME = "TM";    
    public static final String COLUMN_SEQ = "WO_NBR";  
	public static final String SO_CAT_BUSINESS = "1";// Ӫҵ�����࿪ͨ
	public static final String SO_CAT_FAULT = "2";// ��������
	public static final int DEFAULT_PAGE_SIZE_MOBILE=50;
	public static final String WO_SEARCH = "woSearch";
	
	public static final String SA_COMPLAINT_C = "C";
	public static final String FAULT_LEVEL_COMPLAINT = "10140";
	
	/*********************��ﱱ��ӿ�*************************************/
	public static final String SA_PROD_CAT_INTER_ACCESS = "40";
	public static final String SA_TEST_CONTENT_CODE_AD = "1";
	public static final String SA_TEST_CONTENT_CODE_AG = "2";
	public static final String SA_TEST_MODE_A = "A";
	public static final String SA_TEST_MODE_M = "M";
	public static final String SA_TEST_TYPE_T = "T";
	public static final String SA_TEST_SYSTEM_112 = "112";
	public static final String SA_TEST_CONTENT_CODE_L = "L";
	public static final String SA_TEST_CONTENT_CODE_R = "R";
	public static final String FAIL_REASON_FOR_TEST = "T";
	
	public static final String RELATION_FLAG_OBJ = "RELATION_OBJ"; //�ϰ�������־��Դ
	public static final String RELATION_FLAG_RES = "RELATION_RES"; //�ϰ�������־��Ŀ��
	
	/****ͣ������Դ�����Ƿ��⣬�����ļ������ǲ���*****/
	
	public static final String INTER_FILE_PATH = "72001";
	public static final String INTER_FILE_SAVE_METHOD = "72000";
	public static final String SAVE_METHOD_DB = "DB";
	public static final String SAVE_METHOD_NULL = "NULL";
	public static final String SAVE_METHOD_FILE = "FILE";
	public static final String TAB_SUB_SELECT_FLAG_Y = "Y";
	public static final String TAB_SUB_SELECT_FLAG_N = "N";
	
	public static final String SYS_CONFIG_PHASE_NOTIFY_FLAG = "215047"; //�ͷ�ϵͳ�׶�֪ͨ����
	
	public static final String SYS_CONFIG_REPLY_WO_FLAG = "215048"; //�ͷ�ϵͳ�����ظ�����
	
	public static final String SYS_CONFIG_IVR_REPLY_WO_FLAG = "215049"; //����������й����ظ�����
	
	public static final String SYS_CONFIG_WSURL_SAS_CS = "215003"; //CS�ṩ��SASϵͳ webService��ַ
	
	public static final String SAS2CsService = "ossWebservice"; //CS�ṩ��SASϵͳ��webService����
	//���ʹ����˿�����
    public static final String SYS_CONFIG_RES_BUILD_ADDR = "40012"; //���ʹ�����Դ���õ�ַ
    public static final String EID_CHANGED_RES_SERV_REQ = "CHANGED_RES_SERV_REQ"; //��ѯ��Դ��������
    public static final String EID_RES_BUILD_RETURN_WO = "RES_BUILD_RETURN"; //���ʹ�����Դ���óɹ��ص��ӿ�
    public static final String FUNCODE_CHANGED_RES_QUERY_REQ = "changedResServReq";//��Դ�����ѯ����
    public static final String RESOUCE_BUILD_CHG_SERV_SPEC_ID = "3000000"; //���ʹ���ͻ�����
    public static final String RB_FAIL_REASON_4040404 = "4040404"; //�쳣ԭ��֪ͨrms����
    public static final String SO_CAT_RESOUCE_BULID = "9";//���ʹ�����
    public static final String SO_CAT_PORT_CHANGE = "5";//�˿�������	
    public static final String STEP_ID_CHANGE_QUERY_RES = "SC0008"; //��Դ��ѯ����
    public static final String STEP_ID_RES_ARC_REQ = "SC0009";
    public static final String EID_SO_FAIL_RETURN_TO_RMS = "SO_FAIL_RETURN_TO_RMS"; //�˶˿���������RMS
    public static final String EID_SO_RESBUILD_FAIL_RETURN_TO_RMS  = "SO_RESBUILD_FAIL_RETURN_TO_RMS";//�����˻�RMS
    public static final String FUNCODE_SO_FAIL_RETURN_TO_RMS = "soFailReturnToRMS"; //���÷���
    public static final String FUNCODE_SO_RESBUILD_FAIL_RETURN_TO_RMS = "soResBuildFailReturnToRMS"; //�����˻�RMS����
    public static final String ZYJS_LINK_RMS_USERNAME = "gc";
    public static final String ZYJS_LINK_RMS_PASSWORD = "gc";
	public static final String ZYJS_SYSTEM_FLAG = "RB_QUERY";

	public static final String SYS_CONFIG_RMS_BUILD_DEPT = "225049";// ��Դ���貿��
	
	//�������ó��� SPEC_PRPTY���е�FOR_SCENE�ֶ�ֵ
	
	public static final String SPEC_PRPTY_FOR_SCENE_EQPT_PROD = "EQPT_PROD"; //�ն���Ϣ
	public static final String OBJECT_TYPE_SPONSOR_STAFF = "R"; //������

	// �����ƶ����������ܽӿ�  add by baijm 2011-1-6
	// ��·���Ƚӿ�
	public static final String NRMS_ARCHIVE_ATTEMP_CIRUIT = "archiveAttempCiruit" ;
	public static final String NRMS_UPDATE_SHEET_STATE = "updateSheetState";
	
	public static final String NRMS_GENERATE_TRAPH_ATTEMP_SHEET = "generateTraphAttempSheet";
	public static final String NRMS_UPDATE_APPLY_FAILURE_CIRCUIT = "updateApplyFailureCircuit";
	public static final String NRMS_UPDATE_DESIGN_FAILURE_CIRCUIT = "updateDesignFailureCircuit";
	public static final String NRMS_UPDATE_CIRCUIT_CONSTRUCT_RESULT = "updateCircuitConstructResult";
	
	public static final String NRMS_UPDATE_ATTEMP_SHEET_ARCHIVE = "updateAttempSheetArchive";
	public static final String NRMS_GET_ATTEMP_CIRUIT = "getAttempCiruit";

	public static final String NRMS_SERVICE = "TnmsCircuitService"; // ���������ṩ��·���Ƚӿڵ�webservice����
	
	// ��·���Ƚӿ�
	public static final String NRMS_OPTICAL_ARCHIVE_ATTEMP_OPTICAL_WAY = "archiveAttempOpticalWay";
	public static final String NRMS_OPTICAL_UPDATE_APPLY_FAILURE_OPTICAL_WAY = "updateApplyFailureOpticalWay";
	public static final String NRMS_OPTICAL_GENERATE_OPTICAL_WAY_APPLY_SHEET = "generateOpticalWayApplySheet";
	
	public static final String NRMS_OPTICAL_SERVICE = "TnmsOpticalWayService"; // ���������ṩ��·���Ƚӿڵ�webservice����
	
	public static final String NRMS_RESULT_CODE_SUCCESS = "1"; // ���óɹ�
	public static final String NRMS_RESULT_CODE_FAIL = "0"; // ����ʧ��
	
	public static final String SYS_CONFIG_NRMS_RES_PRPTY_ID = "80020"; // �����·��Դ�����б�
	public static final String SYS_CONFIG_NRMS_CIRCUIT_NAME= "80025"; // �����·��Դ���ԣ���·����
	
	public static final String NRMS_FAIL_REASON_ID = "85000"; // �봫�����ܽӿڶ����쳣ԭ�����
	
	public static final String NRMS_STEP_ID_ACTION = "RA0003" ;  // �����·������Դ���û��ڶ���
	public static final String NRMS_OPTICAL_STEP_ID_ACTION = "RA" ; // �����·������Դ���û��ڶ���
	
	// �������ܽӿڲ���ȡֵ
	public static final String NRMS_SER_SUPPLIER = "HA_TNMS"; // �����ṩ��
	public static final String NRMS_SER_CALLER = "HA_IRMS"; // ������÷�
	public static final String NRMS_USERNAME = "4A"; // �û���
	public static final String NRMS_PASSWORD = "Ʊ��"; // ����
	
	// �������ؽӿ�,�Բ���SystemId�����ж��壬ҵ��ͨϵͳId���Լ����壬����������ϵͳ���֣�
    public static final String NRMS_SYSTEM_ID = "sps"; 
    
    // ���ڹ����ɷ����ţ�����Ԥ��ʱ���Ƿ��ɷ�����
    //public static final String SYS_CONFIG_NRMS_IS_QUERY_PRE_ALARM_DATE = "80030";
    
    // �����·���ص�·��Ϣ����Excelͷ�ֶζ���
    public static final String NRMS_FOR_EXCEL_EXT_SO_NBR = "��������";
    public static final String NRMS_FOR_EXCEL_CIRCUIT_NBR = "��·���";
    public static final String NRMS_FOR_EXCEL_CIRCUIT_PRPTY_ID = "��·����ID";
    public static final String NRMS_FOR_EXCEL_CIRCUIT_NAME = "��·��������";
    public static final String NRMS_FOR_EXCEL_CIRCUIT_PRPTY_VALUE = "��·����ֵ";
    
    public static final String NRMS_FOR_EXCEL_EN_EXT_SO_NBR = "soPwcMVO.getExtSoNbr()";
    public static final String NRMS_FOR_EXCEL_EN_CIRCUIT_NBR = "soPwcMVO.getCircuitNbr()";
    public static final String NRMS_FOR_EXCEL_EN_CIRCUIT_PRPTY_ID = "soPwcMVO.getSpecPrptyId()";
    public static final String NRMS_FOR_EXCEL_EN_CIRCUIT_NAME = "soPwcMVO.getSpecPrptyName()";
    public static final String NRMS_FOR_EXCEL_EN_CIRCUIT_PRPTY_VALUE = "soPwcMVO.getSpecPrptyValue()";
	
    // ����ҵ��ͨ�õ����Ƚ���ͬ��
    public static final String SYS_CONFIG_WRITE_XML_4_RMS = "40045";// ��Դ��ѯ�����÷���XML�Ƿ����
	public static final String RES_XML_MSG_XML_TYPE_A = "A";// ��Դ����
	public static final String RES_XML_MSG_XML_TYPE_Q = "Q";// ��Դ��ѯ
	public static final String RES_XML_MSG_XML_TYPE_D = "D";// ��Դ���
	public static final String WO_NBR_SUFFIX = "_R";// ������ź�׺������ʧ�ܻص���Դ�ͷ�map����

	/*********************�����ƶ���ؽӿ�***********************************/
	/********************* �������� begin ***********************************/
	public static final String HA_CRM = "HA_CRM";
	public static final String HA_EOMS = "HA_EOMS";
	public static final String CALLER_CRM_PWD = "123";
	public static final String DEFAULT_VALUE_ZERO = "0";// �ǿ��ֶ�Ĭ��ֵ
	
	///////////////////////////////// SO ////// ///////////////////////////
	public static final String CITY_NAME = "cityName"; // localNetId
	public static final String COUNTY_NAME = "countyName"; // areaId
	public static final String SERIAL_NO = "serialNo"; // extSoNbr
	public static final String URGENT_DEGREE = "urgentDegree"; // priority
	public static final String SERVICE_TYPE = "serviceType"; // prodId
	public static final String SHEET_TYPE = "sheetType"; //chgServSpecId
	public static final String USER_ID = "userId"; // servInstId
	public static final String DEAL_TIME1 = "dealTime1"; // applDate
	public static final String DEAL_TIME2 = "dealTime2"; // Ҫ�����ʱ��
	public static final String APPLY_INFO = "applyInfo"; // remarks
	public static final String BDEPT_CONTACT = "bdeptContact"; // ��չ����������
	public static final String BDEPT_CONTACT_PHONE = "bdeptContactPhone"; //��չ����ϵ��Ϣ
	public static final String CMANAGER_PHONE = "cManagerPhone"; //����Ա������
	public static final String CMANAGER_CONTACT_PHONE = "cManagerContactPhone"; //�ͻ�������ϵ�绰(�ͻ���ϵ�����Ϣ)
	
	///////////////////////////////// SO_ADDR ////// //////////////////////
	public static final String CITY_A = "cityA"; // A�˵�ַ
	public static final String CITY_A_ADDRESS = "cityAAddress"; //A����ϸ��ַ
	public static final String CITY_Z = "cityZ"; // Z�˵�ַ
	public static final String CITY_Z_ADDRESS = "cityZAddress"; //Z����ϸ��ַ
	public static final String CUSTOM_AP_ADDRESS = "customAPAddress"; //��ϸ��ַ
	
	///////////////////////////////// SO_CUST ////// ///////////////////////
	public static final String CUSTOM_NO = "customNo"; //custId
	public static final String CUSTOM_NAME = "customName"; //soCust.custName
	public static final String CUSTOM_LEVEL = "customLevel"; //soCust.customLevel
	public static final String CUSTOM_CONTACT = "customContact"; // ��ϵ��
	public static final String CUSTOM_CONTACT_PHONE = "customContactPhone"; // ��ϵ��Ϣ
	
	/********************* �������� begin ***********************************/
	public static final String N_DEPT_CONTACT = "ndeptContact"; // ���粿����ϵ��
	public static final String N_DEPT_CONTACT_PHONE = "ndeptContactPhone"; // ���粿����ϵ�˵绰
	public static final String DEAL_RESULT = "dealResult"; // ������
	public static final String DEAL_DESC = "dealDesc"; // ����˵��
	public static final String APN_ID = "apnID"; // apnID
	public static final String APN_ADDRESS = "apnAddress"; // apn��ַ��
	public static final String GRE_IP = "greIp"; // GRE IP address��tunnel ip address��
	public static final String GATEWAY_USER_NAME = "gatewayUserName"; // ��¼�����û���
	public static final String GATEWAY_USER_PASSWORD = "gatewayUserPassword"; // ��¼��������
	public static final String CIRCUIT_CODE = "circuitCode"; // ����ר�ߵ�·����
	public static final String TEST_REPORT = "testReport"; // ���Ա���
	public static final String CMNET_ALLOT_PORT = "CMNETAllotPort"; // CMNET�ڵ������˿ں�
	public static final String ALLOT_BROADBAND = "allotBroadBand"; // ���ſͻ����ô���
	public static final String ALLOT_BROADBAND_POSSESS_MODE = "allotBroadBandPossessMode"; // ���ſͻ�����ռ�з�ʽ
	public static final String IP_ADRESS_NUMBER = "IPAdressNumber"; // ˽��IP��ַ������
	public static final String IP_ADRESS = "IPAdress"; // ˽��IP��ַ
	public static final String CHANGE_ALLOT_BROADBAND = "changeAllotBroadBand"; // ҵ���������ô���
	public static final String CHANGE_ALLOT_BROADBAND_POSSESS_MODE = "changeAllotBroadBandPossessMode"; // ҵ���������ռ�÷�ʽ
	public static final String CUSTOM_EQUIPMENT_AREA = "customEquipmentArea"; // ҵ�������ſͻ��豸������ϸλ��
	public static final String NET_RES_CAPACITY = "netResCapacity"; // ������Դ����ȷ��
	public static final String CLIENT_PGM_CAPACITY = "clientPgmCapacity"; // �ͻ��˹�������ȷ��
	public static final String INVEST_EVALUATE = "investEvaluate"; // Ԥ��Ͷ��
	public static final String EXPECT_FINISH_DAYS = "expectFinishdays"; // Ԥ���������
	public static final String IS_OCCUPIED = "isOccupied"; // �Ƿ���Ԥռ
	public static final String RES_IF_FULL = "resIfFull"; // ��Դ�Ƿ�����
	public static final String REMARK = "remark"; // ��ע
	
	public static final String N_DEPT_CONTACT_CH_NAME = "���粿����ϵ��"; // ���粿����ϵ��
	public static final String N_DEPT_CONTACT_PHONE_CH_NAME = "���粿����ϵ�˵绰"; // ���粿����ϵ�˵绰
	public static final String DEAL_RESULT_CH_NAME = "������"; // ������
	public static final String DEAL_DESC_CH_NAME = "����˵��"; // ����˵��
	public static final String APN_ID_CH_NAME = "apnID"; // apnID
	public static final String APN_ADDRESS_CH_NAME = "apn��ַ��"; // apn��ַ��
	public static final String GRE_IP_CH_NAME = "GRE IP address��tunnel ip address��"; // GRE IP address��tunnel ip address��
	public static final String GATEWAY_USER_NAME_CH_NAME = "��¼�����û���"; // ��¼�����û���
	public static final String GATEWAY_USER_PASSWORD_CH_NAME = "��¼��������"; // ��¼��������
	public static final String CIRCUITCODE_CH_NAME = "����ר�ߵ�·����"; // ����ר�ߵ�·����
	public static final String TESTREPORT_CH_NAME = "���Ա���"; // ���Ա���
	public static final String CMNETALLOTPORT_CH_NAME = "CMNET�ڵ������˿ں�"; // CMNET�ڵ������˿ں�
	public static final String ALLOTBROADBAND_CH_NAME = "���ſͻ����ô���"; // ���ſͻ����ô���
	public static final String ALLOTBROADBANDPOSSESSMODE_CH_NAME = "���ſͻ�����ռ�з�ʽ"; // ���ſͻ�����ռ�з�ʽ
	public static final String IPADRESSNUMBER_CH_NAME = "˽��IP��ַ������"; // ˽��IP��ַ������
	public static final String IPADRESS_CH_NAME = "˽��IP��ַ"; // ˽��IP��ַ
	public static final String CHANGEALLOTBROADBAND_CH_NAME = "ҵ���������ô���"; // ҵ���������ô���
	public static final String CHANGEALLOTBROADBANDPOSSESSMODE_CH_NAME = "ҵ���������ռ�÷�ʽ"; // ҵ���������ռ�÷�ʽ
	public static final String CUSTOMEQUIPMENTAREA_CH_NAME = "ҵ�������ſͻ��豸������ϸλ��"; // ҵ�������ſͻ��豸������ϸλ��
	public static final String NETRESCAPACITY_CH_NAME = "������Դ����ȷ��"; // ������Դ����ȷ��
	public static final String CLIENTPGMCAPACITY_CH_NAME = "�ͻ��˹�������ȷ��"; // �ͻ��˹�������ȷ��
	public static final String INVESTEVALUATE_CH_NAME = "Ԥ��Ͷ��"; // Ԥ��Ͷ��
	public static final String EXPECTFINISHDAYS_CH_NAME = "Ԥ���������"; // Ԥ���������
	public static final String ISOCCUPIED_CH_NAME = "�Ƿ���Ԥռ"; // �Ƿ���Ԥռ
	public static final String RESIFFULL_CH_NAME = "��Դ�Ƿ�����"; // ��Դ�Ƿ�����
	public static final String REMARK_CH_NAME = "��ע"; // ��ע
	
	/*********************�����ƶ���ؽӿ�end***********************************/
    // add by baijm 2011-09-02 �����ƶ�ҵ��ͨCRM�ӿ���Ҫ������ͬ��
	public static final String FOR_SCENE_SO_PARSE_CHECK = "SO_PARSE_CHECK";// ��������У��
	
	static public final String ENABLE = "0";// ��Ч
	static public final String UNABLE = "1";// ��Ч
	
	public static final String MSG_TYPE_PM = "PM";//so_msg_center.msg_type�������汾��
	
	public static final String SO_TYPE_BIDE = "W";// ��װ��������������CRM���ݴ�װ��ǣ�����ͨ���ն����󲻽�������ƥ�估����ֱ��ת���װ����

	public static final String CHARGE_FOR_FRONT = "1";// ǰ̨�շ�
	public static final String CHARGE_FOR_BACKGROUND = "3";// װ���շ�


	
	public static final String SYS_CONFIG_LOCAL_VISION_4_NM = "nm";
	public static final String SYS_CONFIG_SPEC_PRPTY_ACCESS_MODE = "60000";
	
	public static final String SYS_CONFIG_IS_JMS = "80001"; // ʵʱͨ���Ƿ�ʹ��JMS
	public static final String EID_RES_RELEASE_4_JZ = "JZ_RES_RELEASE_REQ";
	public static final String FUNCODE_RES_RELEASE_4_JZ_REQUEST = "resCancellationRequest";
	public static final String EID_RES_RETURN_WO_RESP = "RES_RETURN_WO_RESP"; //���ʻص�
	
	public static final String SO_PROCESS_DO_INSTANCE_TRUE = "Y";
	public static final String SO_PROCESS_DO_INSTANCE_FALSE = "N";
	public static final String HANDLE_TYPE_SA_INTERCEPT = "501091";//�����Զ�����
	public static final String HANDLE_TYPE_SA_RECOGNIZE = "501092";//�����Զ�ʶ��
	
	public static final String SO_PROC_INST_ID_NO_INSTANCE = "-1";
	
	//Ĭ���Ƿ�ʵ����
	public static final String DO_INSTANCE_Y = "Y";
	public static final String DO_INSTANCE_N = "N";
	public static final String CAN_NO_INSTANCE_Y = "Y";
	public static final String CAN_NO_INSTANCE_N = "N";
	
	//���̷���״̬
	
	public static final String AVAILABLE = "A"; //�ȴ�����
	
	public static final String CHECKED = "C"; //�ȴ�����

	public static final String PUBLISHED = "P"; //�ȴ�����
	
	public static final String WO_PRESS_TYPE_WO_GROUP = "W";
	
    public static final String SYS_CONFIG_CONTEXT_ROOT = "20000";
    
    public static final String SERV_DEPT_AREA_TYPE = "M";  //M Ӫ������
    
    public static final String PROD_ID_SX="215047";//ɽ��ͬ�������Ʒ����
    
    public static final String PARENT_MAIT_AREA_ID_TYPE="0";//��Ŀ���г�Ϊ�����Ϊ����Ŀ���г�
    
    public static final String SYS_CONFIG_SERV_DEPT_LOCAL_NET_ID = "216003"; // ɽ���Ƿ���������ʱ����
    
    public static final String PARA_MAP_DATE = "date";
    
    public static final String BUSI_STS_WAIT = "W";// ԤԼ�ȴ�
    
    public static final String SYS_CONFIG_IS_SEND_WO_AT_NOW = "71030";// ԤԼ�����Ƿ������ɵ�
    public static final String SYS_CONFIG_SEND_WO_TIME_CONFIG = "71031";// ԤԼ�����ɵ�ʱ������
    
    public static final String CHG_SERV_SPEC_ID_A="10";//�ͷ�Ͷ��ҵ�����͸��ݿͻ������жϿ��װ��
    public static final String CHG_SERV_SPEC_ID_X=",269,270,271,272,273,274,275,276,277,281,";//�ͷ�Ͷ��ҵ�����͸��ݿͻ������ж� ����ƻ�
    
    public static final String SYS_CONFIG_WSURL_CUSTOM = "110005"; // �ͷ�ϵͳ�ṩwebservice��URL
    
    public static final String WO_PRESS_TYPE_BOOK="BOOK";
    
    public static final String SYS_CONFIG_IS_WAIT_PROD_ID="216004";
    
    public static final String SYS_CONFIG_IS_VOICE_PROD_ID="51131";
    public static final String SYS_CONFIG_ZHUANGJI_STEP="51132";
    public static final String SYS_CONFIG_IS_ADSL_PROD_ID="51133";
    public static final String SYS_CONFIG_KUANDAI_STEP="51134";
    
    public static final String SYS_CONFIG_RES_PRPTY_WIRING_CABLE_NAME = "34071";// 3000006 ���ߵ�������
	public static final String SYS_CONFIG_RES_PRPTY_WIRING_CABLE_PAIR = "34072";// 3000007 ���ߵ�������
	public static final String SYS_CONFIG_RES_PRPTY_TRUNK_CABLE_NAME = "34073";// 3000022 ���ɵ�������
	public static final String SYS_CONFIG_RES_PRPTY_TRUNK_CABLE_PAIR = "34074";// 3000023 ���ɵ�������
	
	public static final String ACC_NBR_PRPTY_WIRING_CABLE_NAME="3000006";//���ߵ�������
	public static final String ACC_NBR_PRPTY_WIRING_CABLE_PAIR="3000007";//���ߵ�������
	public static final String ACC_NBR_PRPTY_TRUNK_CABLE_NAME="3000022";//���ɵ�������
	public static final String ACC_NBR_PRPTY_TRUNK_CABLE_PAIR="3000023";//���ɵ�������
    
    /**������ά**/
    
    public static final String PARA_MAP_ADVQUERY_MVO = "AdvQueryMVO";
    public static final String PARA_MAP_PAGINFO = "PagInfo";
    public static final String PARA_MAP_COLUMN_NAME = "culmName";
    public static final String PARA_MAP_WOQUERY_MVO = "WoQueryMVO";
    public static final String PARA_MAP_WO_LIST = "woList";
    public static final String PARA_MAP_RET_TYPE = "retType";
    public static final String PARA_MAP_PARAM_MAP = "paramMap";
    public static final String PARA_MAP_SO_CAT = "soCat";
    public static final String PARA_MAP_WO_STAFF_ID = "woStaffId";
    public static final String PARA_MAP_FAIL_WO_MSG = "failWoMsg";
    public static final String PARA_MAP_STEP_FAIL_REASON_SVO = "stepFailReasonSVO";
    public static final String PARA_MAP_STEP_FAIL_REASON_LIST = "stepFailReasonList";
    public static final String PARA_MAP_SYS_USER_MVO = "sysUserMVO";
    public static final String PARA_MAP_SYS_USER_EXTENDED_MVO = "SysUserExtendedMVO";
    public static final String PARA_MAP_WORK_AREA_MVO = "WorkAreaMVO";
    public static final String PARA_MAP_WORK_AREA_SVO = "WorkAreaSVO";
    public static final String PARA_MAP_SYSTEM_NAME = "SystemName";
    public static final String PARA_MAP_WORK_AREA_LIST = "workAreaList";

    /***Native MOS App**/
    public static final String MOS_FEED_BACK_ID_SEQ = "MOS_FEED_BACK_ID";
    public static final String MOS_CALL_LOG_ID_SEQ = "MOS_CALL_LOG_ID";
    
    public static final String MOS_SURVEY_ID_SEQ = "MOS_SURVEY_ID";
    public static final String STAFF_LOCATIOIN_ID_SEQ = "STAFF_LOCATIOIN_ID";
    
//    public static final String SYS_CONFIG_MOS_SERVER_ADDR = "6000002";//MOSϵͳ�����webservice��ַ
    public static final String SYS_CONFIG_MOS_FLAG_ADDR = "6000045";//�ж��Ƿ���iom��������Դϵͳ
    public static final String SYS_CONFIG_MOS_SERVER_ADDR = "6000005";//MOSϵͳ����˵�������webservice��ַ
    public static final String SYS_CONFIG_MOS_LOCAL_SERVER_ADDR = "6000019";//Mosϵͳ����˵����Լ���webservice��ַ
    public static final String MOS_SERVICE_ADDR_FOR_RMS_TEMP = "6000027";//Mosϵͳ����˵�����Դ��webservice��ַ��������Դ�˲�ʱʹ�ã�
//    public static final String SYS_CONFIG_MOS_SERVER_ADDR = "http://10.93.38.77:8080/trms/services/RmsForMosService";//MOSϵͳ����˵�������webservice��ַ
//    public static final String SYS_CONFIG_MOS_LOCAL_SERVER_ADDR = "http://10.93.38.71:7013/web_mos/services/";//Mosϵͳ����˵����Լ���webservice��ַ
    public static final String SYS_CONFIG_MOS_DETail_DATA_ID = "6000007";//MOS ���������id
    public static final String SYS_CONFIG_MOS_APK_PATH = "6000003";//MOSapk���ص�ַ
    public static final String SYS_CONFIG_MOS_JFORUM_ADDR = "6000010";//֪ʶ���ַ
    public static final String FUNCODE_LOGIN="login"; //��¼
    public static final String FUNCODE_FIND_DEFAULT_WORK_AREA="findDefaultWorkArea"; //Ĭ�Ϲ���
    public static final String FUNCODE_WO_FETCH = "woFetch";//�쵥
    public static final String FUNCODE_WO_RETURN_INIT = "woInitReturn";//��ʼ���ص�����
    public static final String FUNCODE_WO_RETURN_FAIL = "woFailReturn";//ʧ�ܻص� 
    public static final String FUNCODE_WO_RETURN_SUCCESS = "woReturnSuccess";//�ɹ��ص� 
    public static final String FUNCODE_LOCAL_NET="localNet";//�л�����һ��ҳ��--������
    public static final String FUNCODE_WORK_AREA="workArea";//�л���������ҳ��--����
    public static final String FUNCODE_WO_INIT_WOLIST = "initWoList";//������ѯ
    public static final String FUNCODE_WO_INIT_WOLISTS = "initWoLists";//��ʼ�������������Ĺ����б�
    public static final String FUNCODE_INIT_SERV_DEPT = "initServDept";//��ʼ������ά��
    public static final String FUNCODE_MODI_SERV_DEPT = "modiServDept";//�޸�����ά��
    public static final String FUNCODE_CHG_SERV_DEPT = "chgServDept";//������������
    public static final String FUNCODE_STAFF = "queryStaff";//��ѯ����Ա��
    public static final String FUNCODE_WO_Detail = "initWoDetail";//��������
    public static final String FUNCODE_RESERVE_DATE_TIME = "reserveDateTime";//ԤԼ����
    public static final String FUNCODE_CHANGE_LOCAL_NET = "changeLocalNet";//ת���еı������б�
    public static final String FUNCODE_WORK_AREA_TYPE = "workAreaType";//��ù�������
    public static final String FUNCODE_CHANGE_WORK_AREA = "changWorkArea";//ת���еĹ����б�
    public static final String FUNCODE_CHANGE_FAIL_REASON = "failReason";//ת���е�ת��ԭ��
    public static final String FUNCODE_WORK_STAFF = "workStaff";//ת���е�ʩ����Ա�б�
    public static final String FUNCODE_CHANGE_ORDER_SUCCESS = "changeOrderSuccess";//ת�ɳɹ�
    public static final String FUNCODE_FIND_BULLETIN_LIST= "findBulletin";//��ȡ�����б�
    public static final String FUNCODE_SET_DEFAULT_WORK_AREA = "setDefaultWorkArea";//����Ĭ�Ϲ���
    public static final String FUNCODE_GET_BIZ_FILTER_OPTION= "getBizFilterOption";//��ȡҵ��ɸѡѡ��
    public static final String FUNCODE_FEED_BAK = "feedBack";//�û�����
    public static final String FUNCODE_FIND_WO_BAT = "findWoBat";
    public static final String FUNCODE_MOD_FEEDBACK_WO = "modFeedbackWo";
    public static final String FUNCODE_MSG_SEND = "msgSend";//����֪ͨ
    public static final String FUNCODE_STATIS_REPORT="statisReport";//�yӋ���
    public static final String SYS_CONFIG_MOS_SEND_LOCATION_INTERVAL= "6000000";//���������ҵ��ɸѡѡ���б�
    public static final String SYS_CONFIG_MOS_STAFF_LOCATION_INTERVAL= "6000024";
    public static final String SYS_CONFIG_MOS_STAFF_LOCATION_ONCE_MAXNUM= "6000022";
    public static final String SYS_CONFIG_MOS_STAFF_LOCATION_SUBMIT_NUM= "6000023";
    public static final String FUNCODE_WO_LIST = "woList";//�����б�
    public static final String FUNCODE_MOS_VERSION = "mosVersion";//���°汾��Ϣ
    public static final String FUNCODE_QUERY_MOS_CALL_LOG = "queryMosCallLog";//��ѯͨ����¼
    public static final String FUNCODE_ADD_MOS_CALL_LOG = "addCallLog";//���ͨ����¼
    public static final String FUNCODE_QUERY_MOS_CALL_LOG_DETAIL = "queryMosCallLogDetail";//��ѯͨ����¼����
    public static final String FUNCODE_PROCESS_QUERY = "processQuery";//���̲�ѯ
    public static final String FUNCODE_HANDLE_LATER = "handle_later";//��װ
    public static final String REPORT_COLUMN_SEQ = "CREATE_DATE";  //ͳ�Ʊ���
    public static final String FUNCODE_QUERY_REPORT_LIST="queryReportList";//�����ϸ�б�
    public static final String FUNCODE_ADD_MOS_SURVEY = "addMosSurvey";//MOS�طù���
    public static final String SYS_CONFIG_MOS_STEP_FILTER = "6000013";//MOS�طù���
    public static final String SYS_CONFIG_MOS_RESEND_FAIL_REASON_ID = "6000014";//MOS�طù���
    public static final String SYS_CONFIG_MOS_CREATE_MOS_MSG = "6000015";//�Ƿ�����MOS������Ϣ
    public static final String SYS_CONFIG_MOS_PUSH_SERVER_ADDR = "6000016";//MOS������Ϣ�����ַ
    public static final String SYS_CONFIG_MOS_INIT_CONFIG = "6000020";//MOS������Ϣ�����ַ
    public static final String ENCRYPT_USABLE = "6000025";//���ݴ�����ܿ���
    public static final String FUNCODE_MOS_TALK_TO_IOM = "mosTalkToIOM";
    
    public static final String SYS_CONFIG_MOS_QUERY_SYS_CONFIG = "querySysConfig";//ȡ��MOS��Ҫ�Ļ���
    public static final String SYS_CONFIG_MOS_ENCRYPT_CONFIG = "encryptUsable";//ȡ��MOS���ܿ�������
    public static final String SYS_CONFIG_FIND_BY_NOW = "findByNow";//ȡ��MOS��Ҫ�Ļ���
    public static final String SYS_CONFIG_QUERY_MOS_SURVEY = "queryMosSurvey";//��ѯ�ط���Ϣ
    public static final String SYS_CONFIG_ADD_MOS_PICTURE = "addMosPicture";//���ӹ���������Ƭ
    public static final String SYS_CONFIG_QUERY_MOS_PICTURE = "queryMosPicture";//��ѯ����������Ƭ
    public static final String SYS_CONFIG_DELETE_MOS_PICTURE = "deleteMosPicture";//ɾ������������Ƭ
    public static final String SYS_CONFIG_ADD_STAFF_LOCATION = "addStaffLocation";//���Ա��λ��
    public static final String SYS_CONFIG_ADD_STAFF_IOM_LOCATION = "addStaffIomLocation";//���Ա��λ��
    public static final String SYS_CONFIG_INIT_MATERIAL_TYPE = "initMaterialType"; //��ʼ����Ʒ�����Ϣ
    public static final String SYS_CONFIG_QUERY_MATERIAL_TYPE = "queryMaterialType"; //��ѯ��Ʒ�����Ϣ
    public static final String SYS_CONFIG_ADD_MATERIAL_TYPE = "addMaterialType"; //���Ӳ�Ʒ�����Ϣ
    public static final String SYS_CONFIG_UPDATE_MATERIAL_TYPE = "updateMaterialType"; //�޸Ĳ�Ʒ�����Ϣ
    public static final String SYS_CONFIG_DELETE_MATERIAL_TYPE = "deleteMaterialType";//ɾ������
    public static final String SYS_CONFIG_QUERY_WO_COUNT = "queryWoCount";//��ѯ���ϻ�����ж��Ƿ����
    public static final String SYS_CONFIG_WO_HANDLE_INFO = "woHandleInfo"; //��ѯ�ټ�¼
    public static final String SYS_CONFIG_WO_RETURN = "woReturn"; //���ϵ��ص�
    public static final String SYS_CONFIG_INIT_FETCH_LIST = "initFetchList";//��ʼ���쵥�б�
    public static final String FUNCODE_QUERY_TERMAIL = "queryDevicesByStaff";//�ն��豸�б��ѯ
    public static final String FUNCODE_TERMAIL_DETAIL = "queryDeviceByMacAddress";//�ն�����
    public static final String FUNCODE_TERMAIL_ADD = "maintainDeviceStaffRelation";//�ն���ȡ
    public static final String FUNCODE_TERMAIL_DELETE = "releaseDeviceStaffRelation";//�˻��ն�
    public static final String FUNCODE_QUERY_DEVICE_BY_ACC_NBR = "queryDevicesByAccNbr";//��Դ�˲��ȡ�˲���Դ���б�
    public static final String FUNCODE_QUERY_FUNC_DEVICE_BY_ACC_NBR = "queryResourceByServiceAreaAndType";
    public static final String FUNCODE_QUERY_FUNC_DEVICE_BY_NAME = "queryResourceByNameAndType";
    public static final String FUNCODE_UPLOAD_DEVICE_IMAGE = "uploadDeviceImage";//�ϴ���ԴͼƬ
    public static final String FUNCODE_DELETE_DEVICE_IMAGE = "deleteImage";//�ϴ���ԴͼƬ
    public static final String FUNCODE_QUERY_DEVICE_IMAGE_BY_ID = "queryDeviceImageById";//������ԴID��ѯͼƬ
    public static final String FUNCODE_CHECKED_RESULT_WARE_HOUSING = "checkedResultWarehousing";//�����ռ�
    public static final String FUNCODE_QUERY_DICTIONARY_BY_PARAMETER = "queryDictionaryByParameter";//�ֵ���ѯ
    public static final String FUNCODE_RES_QUERY =  "resQuery";//��Դ��ѯ
    public static final String FUNCODE_TERMINAL_CHANGE = "changeTerminal";
    public static final String FUNCODE_MAINTAIN_DEVICE_STAFF_RELATION = "maintainDeviceStaffRelation";//��Ա�����ն��豸
    public static final String FUNCODE_RELEASE_DEVICE_STAFF_RELATION = "releaseDeviceStaffRelation";//�����Ա�ն��豸��ϵ
    public static final String FUNCODE_MODIFY_RES_STS = "modifyResSts";//�޸���Դ״̬
    public static final String FUNCODE_DEVICE_QUERY = "deviceQuery";//��Դ��ѯ
    
    //��Դ�ֵ���ѯ
    public static final String FACTORY = "factory";
    public static final String DEVICE_MODE = "deviceMode";
    public static final String DEVICE_TREATY = "deviceTreaty";
    
    
    
  //  public static final String SYS_CONFIG_MOS_SERVER_ADDR_FOR_ACTION = "6000005";//MOSϵͳ�����webservice��ַ
    public static final String MOS_SERVER_ADDR_FOR_ACTION = "http://10.93.38.34:8080/trms/services/RmsForMosService";//MOSϵͳ�����webservice��ַ
//    public static final String MOS_SELF_SERVER_ADDR_FOR_ACTION  = "http://10.93.38.34:8080/web_mos/services/";//Mosϵͳ����˵����Լ���webservice��ַ
//    public static final String MOS_SERVER_ADDR_FOR_ACTION = "http://10.93.38.77:8080/trms/services/RmsForMosService";//MOSϵͳ�����webservice��ַ
    public static final String MOS_SELF_SERVER_ADDR_FOR_ACTION  = "http://10.93.38.55:8080/web_mos/services/";//Mosϵͳ����˵����Լ���webservice��ַ
    public static final String MOS_SERVICE_ADDR_FOR_RMS = "6000006";//Mosϵͳ����˵�����Դ2��webservice��ַ
    public static final String MOS_SYS = "MOS";
    public static final String RETURN_SYS = "returnSys";
    
    public static final String SYS_CONFIG_WO_RUN_STS_FOR_D="6000011";//��������״̬
    public static final String SYS_CONFIG_WO_STEP_ID="6000012";//��������
    
    public static final String SYS_CONFIG_MOS_RES_PRPTY = "6000018";//���������е���Դ����
    
    public static final String MOS_RES_PRPTY = "2000000,2000001,3000088,3000025,3000027,3000028,3000010,3000012,3000002,3000004,3000080,3000095,3000096,3000093,3000094,3000062,3000064,2000014,2000015,2000021,2000220,3000081,4000014,4000015";;//���������е���Դ����


  //̨�˽ӿڱ�ʶ
    public static final String FUNCODE_TZ_QUERY_DEVICE = "queryDevices";//̨���豸�б��ѯ
    public static final String FUNCODE_TZ_QUERY_PHOTO = "queryPhoto";//̨���豸ͼƬ��ѯ
    public static final String FUNCODE_TZ_QUERY_SINGLE_PHOTO = "querySinglePhoto";//̨���豸����ͼƬ��ѯ
    public static final String FUNCODE_TZ_ADD_DEVICE_INFO = "AddTZDeviceInfo";//����豸̨����Ϣ������������Ϣ��ͼƬ
    public static final String FUNCODE_TZ_DELETE_DEVICE_INFO = "deleteTZDeviceInfo";//ɾ���豸̨����Ϣ������������Ϣ��ͼƬ
    public static final String FUNCODE_TZ_UPDATE_DEVICE_INFO = "updateTZDeviceInfo";//�޸��豸̨����Ϣ������������Ϣ��ͼƬ
    public static final String FUNCODE_TZ_CACHE_INFO_IN_LOGIN = "cacheInfoInLogin";//��¼�ɹ�����Ҫ�������Ϣ
    public static final String FUNC_TZ_FUZZY_QUERY="funcTzFuzzyQuery";//ģ����ѯ
}
