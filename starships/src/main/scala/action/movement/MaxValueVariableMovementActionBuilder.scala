package action.movement

import action.movement.{ConstantMovementActionBuilder, MovementAction, MovementActionBuilder, MovementActionBuilderInput}

class MaxValueVariableMovementActionBuilder(maxValue: Int
                                            , variableMovementAction: VariableMovementActionBuilder
                                            , constantMovementActionBuilder: ConstantMovementActionBuilder) extends MovementActionBuilder:
  def build(actionBuilderInput: MovementActionBuilderInput): MovementAction =
    MaxValueVariableMovementAction(maxValue
      , variableMovementAction.build(actionBuilderInput)
      , constantMovementActionBuilder.build(actionBuilderInput)
      , actionBuilderInput.entity)