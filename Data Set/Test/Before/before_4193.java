class Dummy{
public void testPacketTooLargeException() throws Exception {
    final ConnectionEventListener conListener = new ConnectionListener();
    PooledConnection pc = null;
    pc = this.cpds.getPooledConnection();
    pc.addConnectionEventListener(conListener);
    createTable("testPacketTooLarge", "(field1 LONGBLOB)");
    Connection connFromPool = pc.getConnection();
    PreparedStatement pstmtFromPool = ((ConnectionWrapper) connFromPool).clientPrepare("INSERT INTO testPacketTooLarge VALUES (?)");
this.stmt = con.createStatement();
    this.rs = this.stmt.executeQuery("SHOW VARIABLES LIKE 'max_allowed_packet'");
    this.rs.next();
    int maxAllowedPacket = this.rs.getInt(2);
    int numChars = (int) (maxAllowedPacket * 1.2);
    pstmtFromPool.setBinaryStream(1, new BufferedInputStream(new FileInputStream(newTempBinaryFile("testPacketTooLargeException", numChars))), numChars);
    try {
pstmtFromPool = con.createStatement();
        pstmtFromPool.executeUpdate();
        fail("Expecting PacketTooLargeException");
    } catch (PacketTooBigException ptbe) {
    }
    this.rs = connFromPool.createStatement().executeQuery("SELECT 1");
    assertTrue(this.connectionErrorEventCount == 0);
    assertTrue(this.closeEventCount == 0);
}}

