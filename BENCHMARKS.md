# Benchmarks
10-run average for each test (and total time). 

***Note:*** Excludes loading time.

| Solution          | testSentence | testPoem | testAlice | testBard | testRome | Total Average |
|-------------------|--------------|----------|-----------|----------|----------|---------------|
| HashSet (HashMap) | 1.0ms        | 16.2ms   | 22.0ms    | 212.2ms  | 304.8ms  | 556.2ms       |
| Trie (Iteration)  | 1.0ms        | 73.7ms   | 80.2ms    | 277.2ms  | 409.4ms  | 791.5ms       |
| Trie (Recursion)  | 1.0ms        | 82.1ms   | 82.0ms    | 321.2ms  | 494.1ms  | 980.4ms       |
| TST (Iteration)   | 1.0ms        | 39.0ms   | 48.9ms    | 397.8ms  | 614.5ms  | 1101.2ms      |
| TST (Recursion)   | 1.0ms        | 52.3ms   | 65.3ms    | 475.3ms  | 720.8ms  | 1314.7ms      |
