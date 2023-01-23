// Getting the inputs
void readInput(int argc, char *argv[]) {

    float tot_frac;

    // Validating the number of arguements
    if (argc != 7) {
        printf("Invalid arguements, input: rw_linked_list <n> <m> <thread_count> <mMember> <mInsert> <mDelete>\n");
        exit(0);
    }

    // Setting the input values of n,m and thread count
    n = (int) strtol(argv[1], (char **) NULL, 10);
    m = (int) strtol(argv[2], (char **) NULL, 10);
    thread_count = (int) strtol(argv[3], (char **) NULL, 10);

    // Setting the input values of operation fraction values - member, insert, delete
    float m_member_frac = (float) atof(argv[4]);
    float m_insert_frac = (float) atof(argv[5]);
    float m_delete_frac = (float) atof(argv[6]);

    // Validating the thread count
    if (thread_count <= 0 || thread_count > MAX_THREADS) {
        printf("Invalid thread no, input: thread_count < 1024\n");
        exit(0);
    }

    tot_frac = m_member_frac + m_insert_frac + m_delete_frac;

    //Validating the arguments
    if (n <= 0 || m <= 0 || tot_frac != 1.0) {
        printf("Invalid arguements, input: rw_linked_list <n> <m> <thread_count> <mMember> <mInsert> <mDelete>\n");

        if (n <= 0)
            printf("Invalid n, input: n >0 \n");

        if (m <= 0)
            printf("Invalid m, input: m >0  \n");

        if (tot_frac != 1.0)
            printf("Invalid fractions of operations \n");

        exit(0);
    }
    
    // calculating the total number od each operation - insert, delete, member
    m_insert = (int) (m_insert_frac * m);
    m_delete = (int) (m_delete_frac * m);
    m_member = (int) (m_member_frac * m);
}

