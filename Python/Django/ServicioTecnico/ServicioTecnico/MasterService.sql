drop table account_emailconfirmation;
drop table ACCOUNT_EMAILADDRESS;
drop table auth_group CASCADE CONSTRAINTS;
drop table auth_group_permissions;
drop table auth_permission;
drop table django_admin_log;
drop table django_content_type;
drop table django_migrations;
drop table socialaccount_socialaccount CASCADE CONSTRAINTS;
drop table socialaccount_socialapp CASCADE CONSTRAINTS;
drop table socialaccount_socialapp_sites;
drop table socialaccount_socialtoken;
drop table usuarios;
drop table libro;
drop table django_session CASCADE CONSTRAINTS;
drop table django_site;


SELECT
    id,
    autor,
    tema,
    image,
    stock,
    categoria,
    editorial
FROM
    libro;