/* File : sample_advent */
%module sample_advent
%include "stdint.i"

%inline %{
    extern void adventInitValue(void);
    extern void adventAddValue(uint32_t value);
    extern uint32_t adventGetValue(void);
    %}