//
// Created by hiroshi hashimoto on 15/12/15.
//

#include "sample_advent.h"

uint32_t dataVaule;

void adventInitValue(void) {
    dataVaule = 0;
}

void adventAddValue(uint32_t value) {
    dataVaule += value;
}

uint32_t adventGetValue(void) {
    return dataVaule;
}


