For quick testing, I'm creating an Nginx app.

Results:
- this app was successfully stress tested (i.e. CPU load was successfully simulated and autoscaling was triggered)
  - HPA scaled up replicas from 1 to 3 based on CPU usage hitting 115% (check screenshots)
  - new pods moved through Pending -> ContainerCreating -> Running states
  - the CPU usage dropped back down, and the replicas scaled back to 1 afterward (expected as load decreases)
  - CPU-heavy while :; do x=$((x+1)); done loop inside the pod is a way to burn CPU cycles and create load

Run kubectl top nodes to see current CPU usage on each pod.