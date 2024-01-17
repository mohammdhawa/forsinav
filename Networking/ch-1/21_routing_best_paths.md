# The Best Path

A router selects the best path based on: 

- Longest Prefix Match.
- Metrics.
- Administrative Distance (AD).

## Longest Prefix Match

when a packet destined for the IP address 192.168.1.0.

The shortest range that contains the destination IP

Routing Table:

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\51.png)

## Metrics

Metrics is a value calculated by the routing protocol that indicates how preferred the route is (The lowest value is preferred).

- When <u>a routing protocol</u> has multiple paths to the same destination with the same metrics, it will load balance between them - Equal-Cost Load Balancing.
- Only EIGRP can load balance between unequal-cost paths.

## Administrative Distance (AD)

Defines a value that is used to determine which route will be selected when having multiple paths to the same destination <u>via different routing protocols</u> . The lower the value, the more preferred the route source.

- The different routing protocols use different methods to calculate the metrics (the way they choose the best path), so AD is needed.

![](C:\Users\Mohammad\Desktop\Study-Plan\Networking\images\53.png)