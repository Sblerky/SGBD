ORACLE_BASE=/oracle/app/oracle; export ORACLE_BASE
ORACLE_HOME=/oracle/app/oracle/product/11.2.0/dbhome_1; export ORACLE_HOME
ORACLE_SID=ENSB2019; export ORACLE_SID
ORACLE_TERM=xterm; export ORACLE_TERM

LD_LIBRARY_PATH=$LD_LIBRARY_PATH:$ORACLE_HOME/lib
export LD_LIBRARY_PATH

PATH=$PATH:$ORACLE_HOME/bin:/opt/csw/bin; export PATH

# CLASSPATH pour le fonctionnement de java

CLASSPATH=$ORACLE_HOME/JRE:$ORACLE_HOME/jlib:$ORACLE_HOME/rdbms/jlib
CLASSPATH=$CLASSPATH:$ORACLE_HOME/network/jlib

# Utilisation vi avec ssh -X
export TERM=xterm
