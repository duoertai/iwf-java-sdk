package iwf.core;

import iwf.core.attributes.AttributeLoadingPolicy;
import iwf.core.command.BaseCommand;
import iwf.core.command.CommandCarryOverPolicy;
import iwf.core.command.CommandCarryOverType;
import iwf.core.command.CommandRequest;
import org.immutables.value.Value;

@Value.Immutable
public interface StateOptions {

    /**
     * when using {@link CommandRequest#forAnyCommandClosed or {@link CommandRequest#forAnyCommandsCompleted(BaseCommand...)}
     * there could be some unfinished commands left to this state. This policy decided whether and how to carry over those unfinished command to
     * future states. Default to {@link CommandCarryOverType#NONE} which means no carry over.
     */
    CommandCarryOverPolicy getCommandCarryOverPolicy();

    /**
     * this decides whether to load all the query attributes into {@link WorkflowState#decide} and {@link WorkflowState#start} method
     * default to true
     */
    AttributeLoadingPolicy getQueryAttributesLoadingPolicy();

    /**
     * this decides whether to load all the search attributes into {@link WorkflowState#decide} and {@link WorkflowState#start} method
     * default to true
     */
    AttributeLoadingPolicy getSearchAttributesLoadingPolicy();
}