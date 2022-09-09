======================================================
Oracle Free Use Terms and Conditions (FUTC) License 
======================================================
https://www.oracle.com/downloads/licenses/oracle-free-license.html
===================================================================

ojdbc10-full.tar.gz - JDBC Thin Driver and Companion JARS
===========================================================
This TAR archive (ojdbc10-full.tar.gz) contains the 19.14 release of the Oracle JDBC Thin driver(ojdbc10.jar), the Universal Connection Pool (ucp.jar) and other companion JARs grouped by category. 

(1) ojdbc10.jar (4,491,032 bytes) - 
(SHA1 Checksum: 325ab131be1803763a321514141fab775c731d4a)
Oracle JDBC Driver compatible with JDK10 and JDK11;
(2) ucp.jar (1,690,072 bytes) - (SHA1 Checksum: 10904c010078c1f1f9ebc2815f9b3b1661ed9b77)
Universal Connection Pool classes for use with JDK8, JDK9, and JDK11 -- for performance, scalability, high availability, sharded and multitenant databases.
(3) ojdbc.policy (11,515 bytes) - Sample security policy file for Oracle Database JDBC drivers

======================
Security Related JARs
======================
Java applications require some additional jars to use Oracle Wallets. 
You need to use all the three jars while using Oracle Wallets. 

(4) oraclepki.jar (306,618 bytes) - (SHA1 Checksum: 0cec67b87d2d7a020a5d2e58861eb8a296f21b01)
Additional jar required to access Oracle Wallets from Java
(5) osdt_cert.jar (210,336 bytes) - (SHA1 Checksum: 3d840b37874cd75e4f6f63612ee5490139eb5f6e)
Additional jar required to access Oracle Wallets from Java
(6) osdt_core.jar (312,215 bytes) - (SHA1 Checksum: b9db74597ad060ca3a95703098a61ee6a26e347b)
Additional jar required to access Oracle Wallets from Java

=============================
JARs for NLS and XDK support 
=============================
(7) orai18n.jar (1,663,954 bytes) - (SHA1 Checksum: f3b34205967b868a5927b87e0dbe4de048ab22a5) 
Classes for NLS support
(8) xdb.jar (265,580 bytes) - (SHA1 Checksum: e88b591593971a480c98886c7b2273ceb4d3ec18)
Classes to support standard JDBC 4.x java.sql.SQLXML interface 
(9) xmlparserv2.jar (1,935,495 bytes) - (SHA1 Checksum: 66507f17bc1cb25f7580606ad117e047aec2d1e5)
Classes to support standard JDBC 4.x java.sql.SQLXML interface 
(10) xmlparserv2_sans_jaxp_services.jar (1,932,963 bytes) - (SHA1 Checksum: 4dec436e67ee92bcb116fe57b135e974c35b20a1) 
Classes to support standard JDBC 4.x java.sql.SQLXML interface
====================================================
JARs for Real Application Clusters(RAC), ADG, or DG 
====================================================
(11) ons.jar (156,244 bytes) - (SHA1 Checksum: 46a11930bcc373ea6069176323488241da7e22f4)
for use by the pure Java client-side Oracle Notification Services (ONS) daemon
(12) simplefan.jar (32,169 bytes) - (SHA1 Checksum: d6882e9100e64a5a22be9813afb264b2f3fadb0a)
Java APIs for subscribing to RAC events via ONS; simplefan policy and javadoc

===========================================================================================
NOTE: The diagnosability JARs **SHOULD NOT** be used in the production environment. 
These JARs (ojdbc10_g.jar,ojdbc10dms.jar, ojdbc10dms_g.jar) are meant to be used in the 
development, testing, or pre-production environment to diagnose any JDBC related issues. 

=====================================
OJDBC - Diagnosability Related JARs
=====================================
(13) ojdbc10_g.jar (7,535,348 bytes) - (SHA1 Checksum: e5ccd7269a54b86257281754281658023069bd75)
Same as ojdbc10.jar except compiled with "javac -g" and contains tracing code.

(14) ojdbc10dms.jar (6,260,860 bytes) - (SHA1 Checksum: ac768eb7e1ce0ae07f5ef24622287e75f5109988)
Same as ojdbc10.jar, except that it contains instrumentation to support DMS and limited java.util.logging calls.

(15) ojdbc10dms_g.jar (7,564,941 bytes) - (SHA1 Checksum: 47991a8e51812161a3f4ecea8307de8e70a9f21b)
Same as ojdbc10_g.jar except that it contains instrumentation to support DMS.

(16) dms.jar (2,194,305 bytes) - (SHA1 Checksum: f83c8559d16eeddfcd7bf4fbaa60df1998e94854)
dms.jar required for DMS-enabled JAR files.

==================================================================
Oracle JDBC and UCP - Javadoc and README
==================================================================
(17) JDBC-Javadoc-19c.jar (1,788,935 bytes) - JDBC API Reference 19c

(18) UCP-Javadoc-19c.jar (369,836 bytes) - UCP Java API Reference 19c

(19) JDBC-Readme.txt: It contains general information about the JDBC driver and bugs that have been fixed in the 19.14 release. 

(20) UCP-Readme.txt: It contains general information about UCP and bugs that are fixed in the 19.14 release. 

(21) Bugs-fixed-in-1914.txt: It contains the list of bugs fixed in the 19.14 release. 


=================
USAGE GUIDELINES
=================
Refer to the JDBC Developers Guide (https://docs.oracle.com/en/database/oracle/oracle-database/19/jjdbc/index.html) and Universal Connection Pool Developers Guide (https://docs.oracle.com/en/database/oracle/oracle-database/19/jjucp/index.html) for more details. 
