package dao

import model.{ContainerServiceState, EmrState, ShellCommandState}

trait SundialDao {

  def processDao: ProcessDao
  def processDefinitionDao: ProcessDefinitionDao
  def taskLogsDao: TaskLogsDao
  def taskMetadataDao: TaskMetadataDao
  def triggerDao: TriggerDao
  def containerServiceStateDao: ExecutableStateDao[ContainerServiceState]
  def emrStateDao: ExecutableStateDao[EmrState]
  def shellCommandStateDao: ExecutableStateDao[ShellCommandState]

  def ensureCommitted()
  def close()

}
