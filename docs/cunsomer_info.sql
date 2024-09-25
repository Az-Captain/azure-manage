-- auto-generated definition
create table customer_info
(
    id                varchar(32)         null comment '客户ID',
    user_name         varchar(30)         null comment '账户名称',
    real_name         varchar(60)         null comment '真是姓名',
    user_password     varchar(40)         null comment '密码',
    gender            tinyint(1) unsigned null comment '性别 1-男；2-女',
    phone             varchar(20)         null comment '手机号',
    email             varchar(50)         null comment '电子邮箱',
    id_card           varchar(20)         null comment '身份证号码',
    bank_account_name varchar(20)         null comment '银行账户名',
    bank_account_no   varchar(20)         null comment '银行卡号',
    is_active         tinyint(1)          null comment '是否生效 0-否；1-是',
    del_flag          varchar(1)          null comment '删除标志 1-未删除；0-已删除',
    create_by         varchar(32)         null comment '创建人',
    create_time       timestamp           null comment '创建时间',
    update_by         varchar(32)         null comment '更新人',
    update_time       timestamp           null comment '更新时间'
)
    comment '客户信息表（专门用来数据脱敏测试）';

