using System.Collections.Generic;
using System.Threading.Tasks;
using Camunda.Worker;

namespace CamundaWorker.Handlers
{
    [HandlerTopics("sayHello", LockDuration = 10000)]
    [HandlerVariables("USERNAME")]
    public class SayHelloHandler : ExternalTaskHandler
    {
        public override async Task<IExecutionResult> Process(ExternalTask externalTask)
        {
            if (!externalTask.Variables.TryGetValue("USERNAME", out var usernameVariable))
            {
                return new BpmnErrorResult("NO_USER", "Username not provided");
            }

            var username = usernameVariable.Value;

            await Task.Delay(1000);

            var result = new CompleteResult();
            result.Variables.Add("MESSAGE", Variable.String($"Hello, {username}!"));
            return result;
        }
    }
}