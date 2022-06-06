package com.example.contact_tracking_zhiying.api;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.contact_tracking_zhiying.R;
import com.example.contact_tracking_zhiying.api.History;

import java.util.List;

public class HistoryListAdapter
        extends ListAdapter<History, HistoryListAdapter.HistoryViewHolder> {

    private List<History> historyList;

    public HistoryListAdapter(@NonNull DiffUtil.ItemCallback<History> diffCallback) {
        super(diffCallback);
    }

    static class HistoryViewHolder extends RecyclerView.ViewHolder {
        private final TextView dateTextView;
        private final TextView timeTextView;
        private final TextView locationTextView;

        private HistoryViewHolder(View itemView) {
            super(itemView);
            dateTextView = itemView.findViewById(R.id.locationDate);
            timeTextView = itemView.findViewById(R.id.locationTime);
            locationTextView = itemView.findViewById(R.id.locationTitle);
        }

        public void bind(String date, String time, String location) {
            dateTextView.setText(date);
            timeTextView.setText(time);
            locationTextView.setText(location);
        }

        static HistoryViewHolder create(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.history_item, parent, false);
            return new HistoryViewHolder(view);
        }
    }

    @Override
    public HistoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return HistoryViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(HistoryViewHolder holder, int position) {
        History current = getItem(position);
        holder.bind(current.getDate(),current.getTime(),current.getLocation());

    }

    public static class HistoryDiff extends DiffUtil.ItemCallback<History> {

        @Override
        public boolean areItemsTheSame(@NonNull History oldItem, @NonNull History newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull History oldItem, @NonNull History newItem) {
            return oldItem.getDate().equals(newItem.getDate()) &&
                    oldItem.getTime().equals(newItem.getTime()) &&
                    oldItem.getLocation().equals(newItem.getLocation());
        }
    }
}
