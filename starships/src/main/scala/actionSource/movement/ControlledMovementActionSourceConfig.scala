package actionSource.movement

import actionSource.ActionSourceConfig
import entity.EntityIdControlledMovementKeyPresses
import entity.value.EntityType


trait ControlledMovementActionSourceConfig extends ActionSourceConfig[ControlledMovementActionSource]:
  def controlledMovementKeyPressesList: List[EntityIdControlledMovementKeyPresses]
