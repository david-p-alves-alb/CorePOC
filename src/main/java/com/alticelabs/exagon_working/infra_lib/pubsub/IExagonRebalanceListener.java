package com.alticelabs.exagon_working.infra_lib.pubsub;

import java.util.List;

/**
 * Interface representing a listener that handles partition rebalancing.
 * This interface provides methods to respond to partition revocation and assignment during rebalancing.
 *
 */
public interface IExagonRebalanceListener {
    /**
     * Called when partitions are revoked from the current instance during rebalancing.
     *
     * @param partitions the list of partition identifiers being revoked
     */
    void onPartitionRevoke(List<Integer> partitions);

    /**
     * Called when partitions are assigned to the current instance during rebalancing.
     *
     * @param partitions the list of partition identifiers being assigned
     */
    void onPartitionAssigned(List<Integer> partitions);
}
