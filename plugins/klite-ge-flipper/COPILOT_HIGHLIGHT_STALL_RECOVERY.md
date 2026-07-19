# Copilot highlight stall recovery (0.3.13)

The diagnostic log showed KLite client 1.0.98 loading GE Flipper 0.3.8 and repeatedly clicking the same GE price widget (`component=30474266`, `index=54`) without advancing.

Version 0.3.13 changes the execution path:

1. Known GE setup and collect widgets dispatch their actual live `CC_OP` action.
2. Remaining visual highlights use KLite Core's `KLiteCanvasInput` service when available.
3. The same unchanged highlight is limited to three attempts.
4. A stalled offer setup activates sticky GE back-arrow recovery, preventing an infinite click loop.

The physical mouse cursor remains untouched.
