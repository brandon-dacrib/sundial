package dao.postgres

import java.sql.Connection

import dao._
import model.EmrState

class PostgresSundialDao(implicit conn: Connection) extends SundialDao {

  override def ensureCommitted() {
    conn.commit()
  }

  override def close() {
    if(!conn.isClosed) {
      conn.commit()
      conn.close()
    }
  }

  override lazy val taskLogsDao = new PostgresTaskLogsDao()

  override lazy val triggerDao = new PostgresTriggerDao()

  override lazy val taskMetadataDao = new PostgresTaskMetadataDao()

  override lazy val processDefinitionDao = new PostgresProcessDefinitionDao()

  override lazy val processDao = new PostgresProcessDao()

  override lazy val shellCommandStateDao = new PostgresShellCommandStateDao()

  override lazy val containerServiceStateDao = new PostgresContainerServiceStateDao()

  override def emrStateDao: ExecutableStateDao[EmrState] = new PostgresEmrStateDao()
}
