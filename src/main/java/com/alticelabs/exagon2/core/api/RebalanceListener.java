package com.alticelabs.exagon2.core.api;

import java.util.List;

public interface RebalanceListener {

    void partitionRevoke(List<Integer> partitions);

    void partitionAssigned(List<Integer> partitions);
}
