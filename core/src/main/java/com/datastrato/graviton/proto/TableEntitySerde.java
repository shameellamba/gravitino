/*
 * Copyright 2023 Datastrato.
 * This software is licensed under the Apache License version 2.
 */
package com.datastrato.graviton.proto;

import com.datastrato.graviton.meta.TableEntity;

public class TableEntitySerde implements ProtoSerDe<TableEntity, Table> {
  @Override
  public Table serialize(TableEntity tableEntity) {
    return Table.newBuilder()
        .setId(tableEntity.id())
        .setName(tableEntity.name())
        .setAuditInfo(new AuditInfoSerDe().serialize(tableEntity.auditInfo()))
        .build();
  }

  @Override
  public TableEntity deserialize(Table p) {
    return new TableEntity.Builder()
        .withId(p.getId())
        .withName(p.getName())
        .withAuditInfo(new AuditInfoSerDe().deserialize(p.getAuditInfo()))
        .build();
  }
}