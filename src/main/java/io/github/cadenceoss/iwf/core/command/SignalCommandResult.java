package io.github.cadenceoss.iwf.core.command;

import io.github.cadenceoss.iwf.gen.models.SignalResult;
import org.immutables.value.Value;

@Value.Immutable
public abstract class SignalCommandResult {

    public abstract String getCommandId();

    public abstract String getSignalName();

    public abstract Object getSignalValue();

    public abstract SignalResult.SignalStatusEnum getSignalStatusEnum();
}