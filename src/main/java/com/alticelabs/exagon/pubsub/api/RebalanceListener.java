package com.alticelabs.exagon.pubsub.api;

import java.util.List;

public interface RebalanceListener {

    void partitionRevoke(List<Integer> partitions);

    void partitionAssigned(List<Integer> partitions);
}
