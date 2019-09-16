package com.reactlibrary;

import android.provider.BaseColumns;

public final class RiilcasContract {

    public static class Riilcash implements BaseColumns {
        public static final String TABLE_NAME = "riilcash";
        public static final String COLUMN_NAME_SOURCE_ACCOUNT_PUB = "source_account_pub";
        public static final String COLUMN_NAME_DEST_ACCOUNT_ID = "dest_account_id";
        public static final String COLUMN_NAME_AMOUNT = "amount";
        public static final String COLUMN_NAME_CURRENCY = "currency";
        public static final String COLUMN_NAME_UNIQUE_CODE = "unique_code";
        public static final String COLUMN_NAME_METHOD = "method";
    }
}