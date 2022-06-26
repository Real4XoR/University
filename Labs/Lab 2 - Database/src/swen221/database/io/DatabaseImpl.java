package swen221.database.io;

import swen221.database.lang.*;

public class DatabaseImpl implements Database {

    @Override
    public ColumnType[] getSchema() {
        return new ColumnType[0];
    }

    @Override
    public int getKeyField() {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void addRow(Object... data) throws InvalidRowException, DuplicateKeyException {

    }

    @Override
    public Object[] getRow(Object key) throws InvalidKeyException {
        return new Object[0];
    }

    @Override
    public Object[] getRow(int index) throws IndexOutOfBoundsException {
        return new Object[0];
    }
}
