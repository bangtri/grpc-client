// Generated by the protocol buffer compiler.  DO NOT EDIT!
// source: systemparam.proto

package grpc.service.param;

public interface ResultOrBuilder extends
    // @@protoc_insertion_point(interface_extends:grpc.service.param.Result)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <code>int32 status = 1;</code>
   * @return The status.
   */
  int getStatus();

  /**
   * <code>string message = 2;</code>
   * @return The message.
   */
  String getMessage();
  /**
   * <code>string message = 2;</code>
   * @return The bytes for message.
   */
  com.google.protobuf.ByteString
      getMessageBytes();
}
