package com.twitter.gizzard.shards


trait Shard {
  def shardInfo: ShardInfo
  def weight: Int
  def children: Seq[Shard]
}

trait ShardCopyAdapter[S <: Shard] {
  def readPage(shard: S, cursor: Option[Map[String,Any]], count: Int): (Map[String,Any], Option[Map[String,Any]])
  def writePage(shard: S, data: Map[String,Any])
  def copyPage(source: S, dest: S, cursor: Option[Map[String,Any]], count: Int): Option[Map[String,Any]]
}
