package iwf.integ.basic;

import iwf.core.Client;
import iwf.core.ClientOptions;
import iwf.core.Registry;
import iwf.core.WorkflowStartOptions;
import iwf.spring.TestSingletonWorkerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BasicTest {

    @BeforeEach
    public void setup() {
        TestSingletonWorkerService.startWorkerIfNotUp();
    }

    @Test
    public void testBasicWorkflow() throws InterruptedException {
        final Registry registry = new Registry();
        final BasicWorkflow wf = new BasicWorkflow();
        registry.addWorkflow(wf);

        final Client client = new Client(registry, ClientOptions.localDefault);
        final String wfId = "basic-test-id" + System.currentTimeMillis() / 1000;
        client.StartWorkflow(BasicWorkflow.class, BasicWorkflowS1.StateId, wfId, WorkflowStartOptions.minimum(10));
        // wait for workflow to finish
        Thread.sleep(5 * 1000);
    }
}