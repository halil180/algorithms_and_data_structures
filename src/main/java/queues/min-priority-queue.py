class Pool:
    def __init__(self, n):

        self.elements = []
        for i in range(0, n):
            p = MinHeapElement(-1)
            self.ls.append(p)

    def getElement(self):

        if len(self.ls) > 0:
            return self.ls.pop(-1)

    def returnElement(self, el):

        self.ls.append(el)

    def toString(self):
        pass


class MinHeapElement:

    def __init__(self, prio, parent = None, left = None, right = None):
        # Referenz auf das Heap-Element
        # Prioritätswert
        self.prio = prio
        self.parent = parent
        self.leftChild = left
        self.rightChild = right
        self.cType = None


    def clear(self):
        self.prio = -1
        self.parent = None
        self.leftChild = None
        self.rightChild = None

class MinHeap:
    # Für die Realisierung der Min-Priority Queue werden zwei Datenstrukturen verwendet:
    # - einen Heap, repräsentiert durch eine Instanz der Klasse List, und
    # - eine Instanz der Klasse DoubleLinkedQueue, die eine Queue realisiert.
    # Der Heap unterstützt den Zugriff auf das minimale Element,
    # erlaubt jedoch keine effiziente Realisierung der Operationen decreaseKey und delete.
    # Daher werden zu jedem Heapelement ein Queue-Element angelegt, die miteinander korrespondieren.
    # d.h. jedem Element des Heaps ist ein Element aus ein Element der Queue eineindeutig zugeordnet.
    # Zudem enthalten die Elemente der Queue alle Daten mit Ausnahme des Prioritätswertes.
    # Zur technischen Umsetzung des Heaps: Das erste Element ist ein Dummy-Element, der als Stopper dient.
    # Der Prioritätswert des Dummy-Eelementes ist gleich 0, was kleiner als jeder andere mögliche Prioritätswert sein muss.
    # Damit vermeidet man den Sonderfall einer Prüfung, ob man an der ersten Stelle des Heaps angekommen ist.


    def __init__(self):
        #construct the heap
        self.heap = None
        self.size = 0
        self.maxValue = 1000
        self.elements = []

        self.stopper = MinHeapElement(1000)
        self.elements.append(self.stopper)

        self.root = MinHeapElement(-1000, left = self.stopper, right = self.stopper)
        self.elements.append(self.root)

    def _swap_new(self, node, child):
        # precondition: child is successor of node in the tree structure

        self.printElement(node)
        self.printElement(child)

        if not node == child:

            (parent1, left1, right1) = (node.parent, node.leftChild, node.rightChild)
            (parent2, left2, right2) = (child.parent, child.leftChild, child.rightChild)

            if parent1 == None:
                self.heap = child
            elif parent1.leftChild == node:
                parent1.leftChild = child
            else:
                parent1.rightChild = child

            if not left1 == None:
                left1.parent = child

                if not right1 == None:
                    right1.parent = child

            if not left2 == None:
                left2.parent = node

                if not right2 == None:
                    right2.parent = node

            if parent2 == node:

                if left1 == child:
                    (node.parent, node.leftChild, node.rightChild) = (child, left2, right2)
                    (child.parent, child.leftChild, child.rightChild) = (parent1, node, right1)
                else: #right1 == child
                    (node.parent, node.leftChild, node.rightChild) = (child, left2, right2)
                    (child.parent, child.leftChild, child.rightChild) = (parent1, left1, node)

            else:

                if parent2.leftChild == child:
                    parent2.leftChild = node

                else:
                    parent2.rightChild = node

                (node.parent, node.leftChild, node.rightChild) = (parent2, left2, right2)
                (child.parent, child.leftChild, child.rightChild) = (parent1, left1, right1)

    def _swap_very_new(self, node, child):
        # precondition: child is successor of node in the tree structure

        if not node == child:

            (parent1, left1, right1) = (node.parent, node.leftChild, node.rightChild)
            (parent2, left2, right2) = (child.parent, child.leftChild, child.rightChild)

            if parent1 == None:
                self.heap = child
            elif parent1.leftChild == node:
                parent1.leftChild = child
            else:
                parent1.rightChild = child

            left1.parent = child
            right1.parent = child

            left2.parent = node
            right2.parent = node

            self.printElement(parent2)
            if parent2 == node:

                if left1 == child:
                    (node.parent, node.leftChild, node.rightChild) = (child, left2, right2)
                    (child.parent, child.leftChild, child.rightChild) = (parent1, node, right1)

                else: #right1 == child
                    (node.parent, node.leftChild, node.rightChild) = (child, left2, right2)
                    (child.parent, child.leftChild, child.rightChild) = (parent1, left1, node)

            else:

                if parent2.leftChild == child:
                    parent2.leftChild = node
                else:
                    parent2.rightChild = node

                (node.parent, node.leftChild, node.rightChild) = (parent2, left2, right2)
                (child.parent, child.leftChild, child.rightChild) = (parent1, left1, right1)

            self.printElement(parent2)

    def _swap_very_very_new(self, node, child):
        # precondition: child is successor of node in the tree structure

        if not node == child:

            (parent1, left1, right1) = (node.parent, node.leftChild, node.rightChild)
            (parent2, left2, right2) = (child.parent, child.leftChild, child.rightChild)

            if parent1.leftChild == node:
                parent1.leftChild = child
            else:
                parent1.rightChild = child

            left1.parent = child
            right1.parent = child

            left2.parent = node
            right2.parent = node

            if parent2 == node:

                if left1 == child:
                    (node.parent, node.leftChild, node.rightChild) = (child, left2, right2)
                    (child.parent, child.leftChild, child.rightChild) = (parent1, node, right1)

                else: #right1 == child
                    (node.parent, node.leftChild, node.rightChild) = (child, left2, right2)
                    (child.parent, child.leftChild, child.rightChild) = (parent1, left1, node)

            else:

                if parent2.leftChild == child:
                    parent2.leftChild = node
                else:
                    parent2.rightChild = node

                (node.parent, node.leftChild, node.rightChild) = (parent2, left2, right2)
                (child.parent, child.leftChild, child.rightChild) = (parent1, left1, right1)


    def _down(self, node):
        # versickere das Element mit Index i im Array a

        if self.size > 0:

            done = False
            while not done:
                #if not node.leftChild == None:
                if not node.leftChild == self.stopper:

                    minChild = node.leftChild

                    #if not node.rightChild == None:
                    if not node.rightChild == self.stopper:

                        if node.leftChild.prio > node.rightChild.prio:
                            minChild = node.rightChild

                    if node.prio > minChild.prio:

                        #self._swap_very_new(node, minChild)
                        self._swap_very_very_new(node, minChild)

                    else:
                        done = True
                else:
                    done = True
            return node

        else:
            return None

    def _up(self, node):
        # lasse Element node im Heap aufsteigen

        if self.size > 0:

            done = False
            while not done:
                #if not node.parent == None:
                if not node.parent == self.root:

                    if node.parent.prio > node.prio:
                        #self._swap_very_new(node.parent, node)
                        self._swap_very_very_new(node.parent, node)
                    else:
                        done = True
                else:
                    done = True
            return node
        else:
            return None

    def _setNextNode(self, prio):

        newHeapElement = MinHeapElement(prio, parent = self.root, left = self.stopper, right = self.stopper)

        if self.size == 0:

            self.root.leftChild = newHeapElement
            #self.heap = newHeapElement

        else:
            sequence = self._getSequence(self.size+1)

            #node = self.heap
            node = self.root.leftChild

            for i in range(0, len(sequence)-1):
                if sequence[i] == 'l':
                    node = node.leftChild
                else:
                    node = node.rightChild

            if sequence[-1] == 'l':
                node.leftChild = newHeapElement
                newHeapElement.cType = 'l'
                newHeapElement.parent = node
            else:
                node.rightChild = newHeapElement
                newHeapElement.cType = 'r'
                newHeapElement.parent = node

        return newHeapElement

    def _getLastNode(self):

        if self.size == 0:
            return None
        else:
            sequence = self._getSequence(self.size)

            # node = self.heap
            node = self.root.leftChild

            if len(sequence) == 0:
                return node
            else:

                for i in range(0, len(sequence)):
                    if sequence[i] == 'l':
                        node = node.leftChild
                    else:
                        node = node.rightChild

                return node

    def _getSequence(self, index):

        if index == 0:
            return None
        elif index == 1:
            return []
        elif index == 2:
            return ['l']
        elif index == 3:
            return ['r']
        else:
            # index > 3
            i = index
            ls1 = [i]
            while  i > 1:
                i = int(i/2)
                ls1.insert(0, i)

            ls2 = []
            for i in range(0, len(ls1)-1):
                if 2*ls1[i] == ls1[i+1]:
                    ls2.append('l')
                elif 2*ls1[i]+1 == ls1[i+1]:
                    ls2.append('r')
                else:
                    print("error")

        return ls2

    def _delLastElement(self, node):
        # precondition: node <> None and node is leaf node

        if not node == None:
            if node.parent == None:
                print("error:: delLastelement.parent == None")
                self.heap = None
            else:
                if node.parent.leftChild == node:
                    node.parent.leftChild = self.stopper
                else:
                    node.parent.rightChild = self.stopper

            node.clear()

    def _check(self, ls, node):

        if not (node == None or node == self.stopper):
            # node is neither None reference nor the stopper element

            ls.append(node.prio)
            if not node.leftChild == self.stopper:

                if node.prio > node.leftChild.prio:
                    print("heap condition not satisfied")

                self._check(ls, node.leftChild)

                if not node.rightChild == self.stopper:
                    self._check(ls, node.rightChild)

            elif not node.rightChild == self.stopper:
                    print("left child is None, but not the right child")

    def checkHeap(self):

        if (self.root.leftChild == self.stopper and self.size > 0) or (not self.root.leftChild == self.stopper and self.size == 0):
            print("error::heap is empty, but", self.size)
        else:
            ls = []
            #self._check(ls, self.heap)
            self._check(ls, self.root.leftChild)
            return ls

    def printElement(self, node):
        print("element", node.prio, node, node.parent, node.leftChild, node.rightChild)

    def printElements(self):
        for i in range(0, len(self.elements)):
            node = self.elements[i]
            self.printElement(node)

    def getSize(self):
        return self.size

    def accessMin(self):

        if self.size > 0:

            #return self.heap.prio
            return self.root.leftChild.prio

        else:
            return None

    def deleteMin(self):

        if self.size == 1:
            #qEl = self.heap
            #self.heap = None
            qEl = self.root.leftChild
            self._delLastElement(qEl)
            self.size -= 1

        elif self.getSize() >= 2:
            #minEl = self.heap
            minEl = self.root.leftChild

            lastNode = self._getLastNode()
            #self._swap_very_new(minEl, lastNode)
            self._swap_very_very_new(minEl, lastNode)

            self._delLastElement(minEl)
            self.size -= 1

            self._down(lastNode)

    def insert(self, prio):

        node = self._setNextNode(prio)

        self.elements.append(node)
        self.size += 1
        self._up(node)

        return node

    def decreaseKey(self, prio, qEl):

        if qEl.prio > prio:
            qEl.prio = prio
            self._up(qEl)

    def delete(self, qEl):

        if not qEl == None and not qEl.prio == -1:
            # Diese Abfrage ist leider nötig, da gelöschte Elemente nicht wieder gelöscht dürfen:
            # sonst wird ein weiteres Element aus dem Heap gelöscht
            self.decreaseKey(0, qEl)
            self.deleteMin()
