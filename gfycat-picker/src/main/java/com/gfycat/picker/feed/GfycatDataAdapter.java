/*
 * Copyright (c) 2015-present, Gfycat, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gfycat.picker.feed;

import android.view.ViewGroup;

import com.gfycat.common.Recyclable;
import com.gfycat.common.utils.Logging;
import com.gfycat.core.FeedIdentifier;
import com.gfycat.core.bi.BIContext;
import com.gfycat.core.gfycatapi.pojo.Gfycat;

import java.util.List;
import java.util.Set;

/**
 * Adapter for Gfycat items from DB. For ColumnFeedFragment.
 * <p>
 * Created by dekalo on 26.08.15.
 */
public class GfycatDataAdapter extends GfycatDiffSupportAdapter<GfyWebpViewHolder> {
    private static final String LOG_TAG = GfycatDataAdapter.class.getSimpleName();
    private final Set<Recyclable> weakRecyclableItemsForRelease;
    private FeedIdentifier feedIdentifier;
    private int orientation;
    private final float cornerRadius;
    private final CellController cellController;
    private final BIContext biContext;

    public GfycatDataAdapter(FeedIdentifier identifier, int orientation, float cornerRadius, List<Gfycat> gfycats, CellController cellController, BIContext biContext, Set<Recyclable> weakRecyclableItemsForRelease) {
        super(gfycats);
        feedIdentifier = identifier;
        this.orientation = orientation;
        this.cornerRadius = cornerRadius;
        this.cellController = cellController;
        this.biContext = biContext;
        this.weakRecyclableItemsForRelease = weakRecyclableItemsForRelease;
    }

    @Override
    public void onBindViewHolder(GfyWebpViewHolder holder, Gfycat gfycat) {
        Logging.d(LOG_TAG, "onBindViewHolder(", holder.hashCode(), ", ", gfycat, ") ");
        holder.bind(gfycat, feedIdentifier);
    }

    @Override
    public GfyWebpViewHolder onCreateViewHolder(ViewGroup viewGroup, int index) {
        GfyWebpViewHolder result = new GfyWebpViewHolder(viewGroup.getContext(), cellController, orientation, cornerRadius);
        Logging.d(LOG_TAG, "onCreateViewHolder(", index, ") ", result.hashCode());
        weakRecyclableItemsForRelease.add(result);
        return result;
    }

    @Override
    public boolean onFailedToRecycleView(GfyWebpViewHolder holder) {
        return true;
    }

    /**
     * @return Returns true if range change happens, false otherwise.
     */
    public boolean updateFeed(FeedIdentifier identifier, List<Gfycat> newGfycats) {
        feedIdentifier = identifier;
        return changeGfycats(newGfycats);
    }
}